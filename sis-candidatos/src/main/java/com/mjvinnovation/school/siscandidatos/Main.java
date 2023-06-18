package com.mjvinnovation.school.siscandidatos;

import com.mjvinnovation.school.siscandidatos.csv.CadastroUnico;
import com.mjvinnovation.school.siscandidatos.model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste geração de arquivo CSV dos candidatos ");


        List<Candidato> candidatos = new ArrayList<>();

        candidatos.add(getCandidatoTeste1());
        candidatos.add(getCandidatoTeste2());

        try {
            // arquivo de destino
            Path arquivoDestino = Paths.get("F:\\MJV School\\git\\mjv-school-java-sis-candidatos\\candidatos.csv" );

            // adicionar cabeçalho se for um arquivo novo
            boolean jaExisteArquivo = Files.exists(arquivoDestino);
            if (!jaExisteArquivo) {
                String conteudo = CadastroUnico.headerLineBuilderForCSV() + System.lineSeparator();;
                Files.write(arquivoDestino, conteudo.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

            for(Candidato candidato:candidatos){
                CadastroUnico cadastroUnico = new CadastroUnico(candidato);
                String conteudo = cadastroUnico.lineBuilderForCSV().toString() + System.lineSeparator();
                Files.write(arquivoDestino, conteudo.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static Candidato getCandidatoTeste1() {
        Candidato candidato = new Candidato();
        candidato.setNome("Tiago Edgar Rasia");
        candidato.setCpf("22233344455");
        candidato.setDataNascimento(LocalDate.of(1983, 3, 19));
        candidato.setSexo(Sexo.MASCULINO);

        Contato contato = new Contato();
        contato.setEmail("tiago_rasia@hotmail.com");
        contato.setTelefone("");
        contato.setCelular("19992544146");
        contato.setWhatsappDisponivel(true);
        candidato.setContato(contato);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua José de Freitas");
        endereco.setNumero("65");
        //endereco.setComplemento("");
        endereco.setBairro("Jd Nazareth");
        endereco.setCidade("Mogi Mirim");
        endereco.setEstado("SP");
        candidato.setEndereco(endereco);

        DadosProfissionais dadosProfissionais = new DadosProfissionais();
        dadosProfissionais.setProfissao("");
        dadosProfissionais.setEmpresa("");
        dadosProfissionais.setSalario(2000.0);
        dadosProfissionais.setEmpregoAtual(true);
        candidato.setDadosProfissionais(dadosProfissionais);

        candidato.setHabilidades("Java|Spring|SQL|GIT|Agile");
        candidato.setPretencaoMinima(2200.0);
        candidato.setPretencaoMaxima(7500.0);

        return candidato;
    }

    private static Candidato getCandidatoTeste2() {
        Candidato candidato = new Candidato();
        candidato.setNome("Raimundo Nonato Loureiro Castelo Branco");
        candidato.setCpf("13521779118");
        candidato.setDataNascimento(LocalDate.of(1986, 4, 16));
        candidato.setSexo(Sexo.MASCULINO);

        Contato contato = new Contato();
        contato.setEmail("raimundo.nonato@gmail.com");
        contato.setTelefone("1133511010");
        contato.setCelular("11945652353");
        contato.setWhatsappDisponivel(true);
        candidato.setContato(contato);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Ruas das laranjeiras");
        endereco.setNumero("S/N");
        endereco.setComplemento("Bl 03 ap 113");
        endereco.setBairro("Vila Nazare");
        endereco.setCidade("Teresinam");
        endereco.setEstado("PI");
        candidato.setEndereco(endereco);

        DadosProfissionais dadosProfissionais = new DadosProfissionais();
        dadosProfissionais.setProfissao("Analista de sistemas");
        dadosProfissionais.setEmpresa("Microsoft");
        dadosProfissionais.setSalario(5279.33);
        dadosProfissionais.setEmpregoAtual(true);
        candidato.setDadosProfissionais(dadosProfissionais);

        candidato.setHabilidades("Java|Vue3|Postgres|Spring");
        candidato.setPretencaoMinima(5279.33);
        candidato.setPretencaoMaxima(5279.33);

        return candidato;
    }
}