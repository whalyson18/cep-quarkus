package org.acme;

import javax.enterprise.context.Dependent;

@Dependent
public class WidenetService extends AbstractCepService {
    public WidenetService() {

        super("https://apps.widenet.com.br");
    }

    @Override
    protected String buildPath(String cep) {
        //StringBuilder builder = new StringBuilder();
        //builder.append("busca-cep/api/cep.json");
        //builder.append("?code=" + cep);
        //return builder.toString();
        return String.format("busca-cep/api/cep.json");
    }
}
