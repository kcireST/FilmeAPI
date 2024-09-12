package br.edu.fatecpg.filmes.model;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public record Resultado(
        @JsonAlias("Title") String titulo,
        @JsonAlias("Runtime") String duracao,
        @JsonAlias("Country") String pais,
        @JsonAlias("Poster") String poster){
}
