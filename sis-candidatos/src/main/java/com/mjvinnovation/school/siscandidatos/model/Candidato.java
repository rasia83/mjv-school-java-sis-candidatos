package com.mjvinnovation.school.siscandidatos.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Candidato {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Sexo sexo;
    private Contato contato;
    private Endereco endereco;
    private DadosProfissionais dadosProfissionais;
    private String habilidades ;
    private Double pretencaoMinima;
    private Double pretencaoMaxima;




}
