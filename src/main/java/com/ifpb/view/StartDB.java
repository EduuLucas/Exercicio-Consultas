package com.ifpb.view;

import com.ifpb.model.*;
import com.ifpb.model.Enum.TelefoneType;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StartDB {

    private List<Aluno> alunos = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Livro> livrosJPQL = new ArrayList<>();
    private List<Livro> livrosCRITERIA = new ArrayList<>();
    private List<Telefone> telefones1 = new ArrayList<>();
    private List<Telefone> telefones2 = new ArrayList<>();
    private EntityManager em;

    public StartDB(EntityManager em) {
        this.em = em;
    }


    public void addAlunos(){

        alunos.add(new Aluno("Lucas", "111.111.111-111", 23, LocalDate.of(1999, 12,16), "11111", "2019.1", LocalDate.of(2019, 07,15),
                new Endereco(
                        "Travessa Januario Rolim de Albuquerque", "Cajazeiras", "58900000", "Por do Sol")));

        alunos.add(new Aluno("Eduardo", "222.222.222-222", 19, LocalDate.of(1999, 12,15), "22222", "2017.1", LocalDate.of(2017, 07,15),
                new Endereco(
                        "Pres João Pessoa", "Cajazeiras", "58900000", "Centro")));

        alunos.add(new Aluno("Carlos", "333.333.333-333", 25, LocalDate.of(1997, 04,23), "33333", "2015.2", LocalDate.of(2015, 07,15),
                new Endereco(
                        "Jacques Demolay", "Cajazeiras", "58900000", "Jardim Oasis")));

        alunos.add(new Aluno("Larissa", "444.444.444-444", 20, LocalDate.of(1998, 03,12), "44444", "2017.2", LocalDate.of(2017, 07,15),
                new Endereco(
                        "Vitoria Bezerra", "Cajazeiras", "58900000", "Boa Vista")));

        alunos.add(new Aluno("Samaritana", "555.555.555-555", 20, LocalDate.of(1995, 01,07), "55555", "2016.1", LocalDate.of(2016, 07,15),
                new Endereco(
                        "Higino Rolim", "Cajazeiras", "58900000", "Centro")));

    }

    public void addLivrosJPQL(){

        Livro JPQL_Esquente_A_Cabeça = new Livro();
        JPQL_Esquente_A_Cabeça.setTitulo("JPQL_Esquente_A_Cabeça");
        JPQL_Esquente_A_Cabeça.setISBN("1111");
        JPQL_Esquente_A_Cabeça.setLancamento(LocalDate.of(2016,03,12));

        Livro JPQL_Esfrie_A_Cabeça = new Livro();
        JPQL_Esfrie_A_Cabeça.setTitulo("JPQL_Esfrie_A_Cabeça");
        JPQL_Esfrie_A_Cabeça.setISBN("2222");
        JPQL_Esfrie_A_Cabeça.setLancamento(LocalDate.of(2015,06,21));

        livrosJPQL.add(JPQL_Esquente_A_Cabeça);
        livrosJPQL.add(JPQL_Esfrie_A_Cabeça);

    }
    public void addLivrosCRITERIA(){

        Livro CRITERIA_Esquente_A_Cabeça = new Livro();
        CRITERIA_Esquente_A_Cabeça.setTitulo("CRITERIA_Esquente_A_Cabeça");
        CRITERIA_Esquente_A_Cabeça.setISBN("3333");
        CRITERIA_Esquente_A_Cabeça.setLancamento(LocalDate.of(2017,02,10));

        Livro CRITERIA_Esfrie_A_Cabeça = new Livro();
        CRITERIA_Esfrie_A_Cabeça.setTitulo("CRITERIA_Esfrie_A_Cabeça");
        CRITERIA_Esfrie_A_Cabeça.setISBN("4444");
        CRITERIA_Esfrie_A_Cabeça.setLancamento(LocalDate.of(2019,07,23));

        livrosCRITERIA.add(CRITERIA_Esquente_A_Cabeça);
        livrosCRITERIA.add(CRITERIA_Esfrie_A_Cabeça);

    }

    public void addAutores(){

        autores.add(new Autor("Ricardo", "666.666.666-666", 23, LocalDate.of(1993, 12,16), "IFPB", new Endereco(
                                "Treze de Maio", "Cajazeiras", "58900000", "Centro"),
                livrosJPQL));
        autores.add(new Autor("Job", "777.777.777-777", 23, LocalDate.of(1993, 12,16), "IFPB", new Endereco(
                                "Treze de Maio", "Cajazeiras", "58900000", "Centro"),
                livrosCRITERIA));

    }

    public void addTelefones(){

        Telefone telefone1 = new Telefone();
        telefone1.setNumero("11111-1111");
        telefone1.setTipo(TelefoneType.RESIDENCIAL);

        Telefone telefone2 = new Telefone();
        telefone2.setNumero("22222-22228");
        telefone2.setTipo(TelefoneType.COMERCIAL);

        Telefone telefone3 = new Telefone();
        telefone3.setNumero("33333-3333");
        telefone3.setTipo(TelefoneType.RESIDENCIAL);

        telefones1.add(telefone1);
        telefones1.add(telefone2);
        telefones2.add(telefone3);

    }

    public void addProfessores(){

        professores.add(new Professor("Ari", "888.888.888-888", 23, LocalDate.of(1992, 10,23), 7000.10, telefones1, new Endereco(
                "José Ferreira Pires", "Cajazeiras", "58900000", "Fátima Santos")));

        professores.add(new Professor("Stofanio", "999.999.999-999", 23, LocalDate.of(1992, 10, 23), 5000.50, telefones2, new Endereco(
                "Que atividade facil", "Cajazeiras", "58900000", "Centro")));

    }



    public void Inicia() {

        addAlunos();
        addLivrosJPQL();
        addLivrosCRITERIA();
        addAutores();
        addTelefones();
        addProfessores();

        em.getTransaction().begin();

        for (Aluno aluno : alunos) {
            em.persist(aluno);
        }
        for (Professor professor : professores) {
            em.persist(professor);
        }
        for(Telefone telefone:telefones1){
            em.persist(telefone);
        }
        for(Telefone telefone:telefones2){
            em.persist(telefone);
        }
        for(Livro livro:livrosCRITERIA){
            em.persist(livro);
        }
        for(Livro livro:livrosJPQL){
            em.persist(livro);
        }
        for(Autor autor: autores){
            em.persist(autor);
        }
        em.getTransaction().commit();


    }




}
