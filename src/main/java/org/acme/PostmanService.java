package org.acme;

import javax.enterprise.context.Dependent;


public class PostmanService extends AbstractCepService {
    public PostmanService() {

        super("https://api.postmon.com.br");
    }

    @Override
    protected String buildPath(String cep) {
        return String.format("/v1/cep/%s", cep);
    }
}
