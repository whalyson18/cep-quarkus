package org.acme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;

public class Endereco {
    @JsonbProperty("address")
    @Getter @Setter private String logradouro;
    @Getter @Setter private String complemento;
    @JsonbProperty("district")
    @Getter @Setter private String bairro;
    @JsonbProperty("city")
    @Getter @Setter private String localidade;
    @JsonbProperty("state")
    @Getter @Setter private String uf;
    @JsonbProperty("code")
    @Getter @Setter private String cep;
}
