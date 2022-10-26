package org.acme;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.logging.Logger;

public abstract class AbstractCepService implements CepService {
    private static final Logger LOG = Logger.getLogger(AbstractCepService.class.getName());
    private final WebTarget target;
    private String dominio;

    public AbstractCepService(String dominio) {
        this.dominio = insertTrailingSlash(dominio);
        Client client = ClientBuilder.newClient();
        this.target = client.target(dominio);
    }

    protected final String insertTrailingSlash(String path){
        return path.endsWith("/") ? path : path + "/";
    }

    protected abstract String buildPath(String cep);

    protected String getFullPath(String cep){
        return this.dominio + buildPath(cep);
    }
    @Override
    public Endereco buscaEndereco(String cep) {
        LOG.info(String.format("CEP %s usando o serviço %s", cep, dominio));
        LOG.info(target.path(buildPath(cep)).getUri().toString());
        //return target.path(buildPath(cep)).request().get(Endereco.class);
        return target.path(buildPath(cep)).queryParam("code", cep).request().get(Endereco.class);
    }
}
