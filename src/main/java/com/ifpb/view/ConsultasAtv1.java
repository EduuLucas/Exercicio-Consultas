package com.ifpb.view;

import com.ifpb.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

public class ConsultasAtv1 {

    @PersistenceContext
    private static EntityManager entityManager;

    public static void main(String[] args) {

        entityManager = Persistence.createEntityManagerFactory("Exercicio-consulta").createEntityManager();
        StartDB sdb = new StartDB(entityManager);
        sdb.Inicia();

//        letraAJPQL();
//        letraBJPQL();
//        letraCJPQL();
//        letraDJPQL();
//        letraEJPQL();
//        letraFJPQL();
//        letraACRITERIA();
//        letraBCRITERIA();
//        letraCCRITERIA();
//        letraDCRITERIA();
//        letraECRITERIA();
//        letraFCRITERIA();

    }

    private static void letraAJPQL() {
        String jpql = "SELECT l FROM Livro l WHERE NOT EXISTS " + "(SELECT a FROM l.autores a WHERE a.dataNascimento = :datanascimento) ";
        TypedQuery<Livro> query = entityManager.createQuery(jpql, Livro.class);
        LocalDate datanascimento = LocalDate.of(1982, 11, 21);
        query.setParameter("datanascimento", datanascimento);
        for (Livro livro : query.getResultList()) {
            System.out.println(livro.getTitulo());
        }
    }

    private static void letraBJPQL() {
        String jpql = "SELECT p FROM Professor p WHERE p.endereco.rua LIKE 'Que atividade facil' AND EXISTS " + "(SELECT t FROM p.telefones t)";
        TypedQuery<Professor> query = entityManager.createQuery(jpql, Professor.class);
        for (Professor p : query.getResultList()) {
            System.out.println(p.getNome());
        }
    }

    private static void letraCJPQL() {
        String jpql = "SELECT NEW com.ifpb.model.AlunoVO(a.nome, a.cpf, a.idade) FROM Aluno a WHERE a.turma like '2019.1'";
        TypedQuery<AlunoVO> query = entityManager.createQuery(jpql, AlunoVO.class);
        for (AlunoVO a : query.getResultList()){
            System.out.println(a.getNome());
        }
    }

    private static void letraDJPQL() {
        String jpql = "SELECT p FROM Professor p WHERE EXISTS " + "( SELECT t FROM p.telefones t WHERE t.numero like '%8')";
        TypedQuery<Professor> query = entityManager.createQuery(jpql, Professor.class);
        for (Professor p : query.getResultList()) {
            System.out.println(p.getNome());
        }
    }

    private static void letraEJPQL() {
        String jpql = "SELECT l FROM Livro l WHERE EXISTS" + "(SELECT a FROM l.autores a WHERE a.endereco.cidade = 'Cajazeiras') AND l.lancamento BETWEEN :lancamentoinicio AND :lancamentofim";
        TypedQuery<Livro> query = entityManager.createQuery(jpql, Livro.class);
        LocalDate lancamentoinicio = LocalDate.of(2019, 1, 1);
        LocalDate lancamentofim = LocalDate.of(2019,12,12);
        query.setParameter("lancamentoinicio", lancamentoinicio);
        query.setParameter("lancamentofim", lancamentofim);
        for (Livro l : query.getResultList()) {
            System.out.println(l.getTitulo());
        }
    }

    private static void letraFJPQL() {
        String jpql = "SELECT l FROM Livro l WHERE EXISTS " + "(SELECT a FROM l.autores a WHERE a.nome LIKE 'J%')";
        TypedQuery<Livro> query = entityManager.createQuery(jpql, Livro.class);
        for (Livro l : query.getResultList()) {
            System.out.println(l.getTitulo());
        }
    }

    private static void letraACRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
        Root<Autor> autor = criteria.from(Autor.class);
        Join<Autor, Livro> livro = autor.join("livros", JoinType.INNER);
        LocalDate data = LocalDate.of(1997, 1, 10);
        criteria.select(livro);
        for (Livro livro1 : entityManager.createQuery(criteria).getResultList()) {
            System.out.println(livro1.getTitulo());
        }
    }

    private static void letraBCRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Professor> criteria = builder.createQuery(Professor.class);
        Root<Professor> p = criteria.from(Professor.class);
        criteria.select(p).where(builder.and(builder.equal(p.get("endereco").get("rua"), "Que atividade facil"), builder.isNotEmpty(p.get("telefones"))));
        for (Professor professor : entityManager.createQuery(criteria).getResultList()) {
            System.out.println(professor.getNome());
        }
    }

    private static void letraCCRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Aluno> criteria = builder.createQuery(Aluno.class);
        Root a = criteria.from(Aluno.class);
        criteria.select(a).where(builder.equal(a.get("turma"), "2019.1"));
        for (Aluno aluno : entityManager.createQuery(criteria).getResultList()) {
            System.out.println(aluno.getNome());
        }
    }

    private static void letraDCRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Professor> criteria = builder.createQuery(Professor.class);
        Root p = criteria.from(Professor.class);
        Join<Professor, Telefone> t = p.join("telefones");
        criteria.select(p).where(builder.like(t.get("numero"), "%8"));
        for (Professor professor : entityManager.createQuery(criteria).getResultList()) {
            System.out.println(professor.getNome());
        }
    }

    private static void letraECRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
        Root<Livro> l = criteria.from(Livro.class);
        Join<Livro, Autor> a = l.join("autores");
        LocalDate inicio = LocalDate.of(1996, 1, 13);
        LocalDate fim = LocalDate.of(1998, 1, 13);
        criteria.select(l).where(builder.and(builder.equal(a.get("endereco").get("cidade"), "Cajazeiras"), builder.between(l.get("lancamento"),inicio, fim)));
        for (Livro livro : entityManager.createQuery(criteria).getResultList()) {
            System.out.println(livro.getTitulo());
        }
    }

    private void letraFCRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Livro> criteria = builder.createQuery(Livro.class);
        Root<Livro> l = criteria.from(Livro.class);
        Join<Livro, Autor> livroAutorJoin = l.join("autores");
        criteria.select(l).where(builder.like(livroAutorJoin.get("nome"),"F%"));
        for (Livro livro : entityManager.createQuery(criteria).getResultList()) {
            System.out.println(livro.getTitulo());
        }
    }

}
