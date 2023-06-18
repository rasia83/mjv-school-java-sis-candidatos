package com.mjvinnovation.school.siscandidatos.csv;

import com.mjvinnovation.school.siscandidatos.model.Candidato;
import com.mjvinnovation.school.siscandidatos.model.Sexo;

import java.time.LocalDate;


public class CadastroUnico {

    private static String separadorCSV = ";";

    /** Dados Pessoais **/
    private String nome = " ";
    private String cpf = " ";
    private LocalDate dataNascimento = LocalDate.now() ;
    private Sexo sexo = Sexo.valueOf("MASCULINO");

    /** Dados Endereço **/
    private String logradouro = " ";
    private String numero = " ";
    private String complemento = " ";
    private String bairro = " ";
    private String cidade = " ";
    private String estado = " ";

    /** Dados Contato **/
    private String email = " ";
    private String telefone = " ";
    private String celular = " ";
    private boolean whatsappDisponivel = false;

    /** Dados Profissionais **/
    private String profissao = " ";
    private String empresa = " ";
    private Double salario = 0.0;
    private boolean empregoAtual = false;

    /** Habilidades **/
    private String habilidades = " ";

    /** Pretenção Salarial **/
    private Double pretencaoMinima = 0.0;
    private Double pretencaoMaxima = 0.0;


    public CadastroUnico() {
    }


    public CadastroUnico(Candidato candidato) {
        this.nome = candidato.getNome();
        this.cpf = candidato.getCpf();
        this.dataNascimento = candidato.getDataNascimento();
        this.sexo = candidato.getSexo();
        this.logradouro = candidato.getEndereco().getLogradouro();
        this.numero = candidato.getEndereco().getNumero();
        this.complemento = candidato.getEndereco().getComplemento();
        this.bairro = candidato.getEndereco().getBairro();
        this.cidade = candidato.getEndereco().getCidade();
        this.estado = candidato.getEndereco().getEstado();
        this.email = candidato.getContato().getEmail();
        this.telefone = candidato.getContato().getTelefone();
        this.celular = candidato.getContato().getCelular();
        this.whatsappDisponivel = candidato.getContato().isWhatsappDisponivel();
        this.profissao = candidato.getDadosProfissionais().getProfissao();
        this.empresa = candidato.getDadosProfissionais().getEmpresa();
        this.salario = candidato.getDadosProfissionais().getSalario();
        this.empregoAtual = candidato.getDadosProfissionais().isEmpregoAtual();
        this.habilidades = candidato.getHabilidades();
        this.pretencaoMinima = candidato.getPretencaoMinima();
        this.pretencaoMaxima = candidato.getPretencaoMaxima();
    }

    public static String headerLineBuilderForCSV() {
        StringBuilder builder = new StringBuilder();

        builder.append("Nome" + separadorCSV);
        builder.append("CPF" + separadorCSV);
        builder.append("Data" + separadorCSV);
        builder.append("Sexo" + separadorCSV);
        builder.append("Logradouro" + separadorCSV);
        builder.append("Numero" + separadorCSV);
        builder.append("Complemento" + separadorCSV);
        builder.append("Bairro" + separadorCSV);
        builder.append("Cidade" + separadorCSV);
        builder.append("Estado" + separadorCSV);
        builder.append("E-mail" + separadorCSV);
        builder.append("Telefone" + separadorCSV);
        builder.append("Celular" + separadorCSV);
        builder.append("WhatsApp" + separadorCSV);
        builder.append("Profissão" + separadorCSV);
        builder.append("Empresa" + separadorCSV);
        builder.append("Salário" + separadorCSV);
        builder.append("Emprego Atual" + separadorCSV);
        builder.append("Habilidades" + separadorCSV);
        builder.append("Pretenção Minima" + separadorCSV);
        builder.append("Pretenção Maxima" + separadorCSV);

        // builder.append("\n"); // + System.lineSeparator();
        return builder.toString();
    }

    public StringBuilder lineBuilderForCSV() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.nome + separadorCSV);
        builder.append(this.cpf + separadorCSV);
        builder.append(this.dataNascimento + separadorCSV);
        builder.append(this.sexo + separadorCSV);
        builder.append(this.logradouro + separadorCSV);
        builder.append(this.numero + separadorCSV);
        builder.append(this.complemento + separadorCSV);
        builder.append(this.bairro + separadorCSV);
        builder.append(this.cidade + separadorCSV);
        builder.append(this.estado + separadorCSV);
        builder.append(this.email + separadorCSV);
        builder.append(this.telefone + separadorCSV);
        builder.append(this.celular + separadorCSV);
        builder.append(this.whatsappDisponivel + separadorCSV);
        builder.append(this.profissao + separadorCSV);
        builder.append(this.empresa + separadorCSV);
        builder.append(this.salario + separadorCSV);
        builder.append(this.empregoAtual + separadorCSV);
        builder.append(this.habilidades + separadorCSV);
        builder.append(this.pretencaoMinima + separadorCSV);
        builder.append(this.pretencaoMaxima + separadorCSV);

        // builder.append("\n"); // + System.lineSeparator();
        return builder;
    }

}
