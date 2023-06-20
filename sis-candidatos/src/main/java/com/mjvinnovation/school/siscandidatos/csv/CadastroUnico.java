package com.mjvinnovation.school.siscandidatos.csv;

import com.mjvinnovation.school.siscandidatos.model.Candidato;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;


public class CadastroUnico {

    private static String separadorCSV = ";";

    private final DateTimeFormatter DATA_FORMATO_CSV = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final Locale LOCALE_PT_BR = new Locale("pt", "BR");


    /** Dados Pessoais **/
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String sexo;

    /** Dados Endereço **/
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    /** Dados Contato **/
    private String email;
    private String telefone;
    private String celular;
    private String whatsappDisponivel;

    /** Dados Profissionais **/
    private String profissao;
    private String empresa;
    private String salario;
    private String empregoAtual;

    /** Habilidades **/
    private String habilidades;

    /** Pretenção Salarial **/
    private String pretencaoMinima;
    private String pretencaoMaxima;



    public CadastroUnico(Candidato candidato) {
        this.nome = Objects.toString( candidato.getNome() , "");
        this.cpf = Objects.toString( candidato.getCpf() , "");
        this.dataNascimento = Objects.toString( candidato.getDataNascimento().format(DATA_FORMATO_CSV) , "");
        this.sexo = candidato.getSexo().toString();
        this.logradouro = Objects.toString( candidato.getEndereco().getLogradouro() , "");
        this.numero = Objects.toString( candidato.getEndereco().getNumero() , "");
        this.complemento = Objects.toString( candidato.getEndereco().getComplemento() , "");
        this.bairro = Objects.toString( candidato.getEndereco().getBairro() , "");
        this.cidade = Objects.toString( candidato.getEndereco().getCidade() , "");
        this.estado = Objects.toString( candidato.getEndereco().getEstado() , "");
        this.email = Objects.toString( candidato.getContato().getEmail() , "");
        this.telefone = Objects.toString( candidato.getContato().getTelefone() , "");
        this.celular = Objects.toString( candidato.getContato().getCelular() , "");
        this.whatsappDisponivel = candidato.getContato().isWhatsappDisponivel()?"true":"false";
        this.profissao = Objects.toString( candidato.getDadosProfissionais().getProfissao() , "");
        this.empresa = Objects.toString( candidato.getDadosProfissionais().getEmpresa() , "");
        this.salario = NumberFormat.getCurrencyInstance(LOCALE_PT_BR).format(candidato.getDadosProfissionais().getSalario());
        this.empregoAtual = candidato.getDadosProfissionais().isEmpregoAtual()?"true":"false";
        this.habilidades = Objects.toString( candidato.getHabilidades() , "");
        this.pretencaoMinima = NumberFormat.getCurrencyInstance(LOCALE_PT_BR).format(candidato.getPretencaoMinima());
        this.pretencaoMaxima = NumberFormat.getCurrencyInstance(LOCALE_PT_BR).format(candidato.getPretencaoMaxima());
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
