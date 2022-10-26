package org.acme;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/cep")
public class CepResource {
    @Inject
    CepService service;

    @GET
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco getEndereco(@PathParam("cep") String cep) {
        return service.buscaEndereco(cep);
    }
}