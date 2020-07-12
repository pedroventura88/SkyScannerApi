package com.estudo.skyscannerapi.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Local {

    @Id
    private Long id;
    private String codigoLocal;
    private String nomeLocal;
    private String codigoPais;
    private String regiao;
    private String codigoCidade;
    private String nomePais;

}
