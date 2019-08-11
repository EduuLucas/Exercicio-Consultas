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

public class ConsultasAtvParte2 {

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
//        letraACRITERIA();
        letraBCRITERIA();
//        letraCCRITERIA();
//        letraDCRITERIA();

    }

    private static void letraAJPQL() {
        String jpql = "SELECT e.nome,p.titulo,a.nome FROM Escritor e, IN (e.publicacoes) p, IN(p.areas) a WHERE  e.id = 3";
        List<Object[]> resultado = entityManager.createQuery(jpql).getResultList();
        for (Object[] o : resultado) {
            System.out.println("--------------------------------------------");
            System.out.println(o[0]);
            System.out.println(o[1]);
            System.out.println(o[2]);
            System.out.println("--------------------------------------------");
        }
    }

    private static void letraBJPQL() {
        String jpql = "SELECT p.titulo, r.nome FROM Revisor  r, IN (r.publicacoes) p WHERE EXISTS " + "(SELECT ar FROM p.areas ar WHERE ar.nome LIKE 'industria')";
        List<Object[]> resultado = entityManager.createQuery(jpql).getResultList();
        for (Object[] o : resultado) {
            System.out.println("--------------------------------------------");
            System.out.println(o[1]);
            System.out.println(o[0]);
            System.out.println("--------------------------------------------");
        }
    }

    private static void letraCJPQL() {
        String jpql = "SELECT r FROM Revisor r, IN (r.publicacoes) p WHERE p.titulo LIKE 'Java%'";
        TypedQuery<Revisor> query = entityManager.createQuery(jpql, Revisor.class);
        for (Revisor revisor : query.getResultList()) {
            System.out.println(revisor.getNome());
        }
    }

    private static void letraDJPQL() {
        String jpql = "SELECT e.nome, COUNT(p) FROM Escritor e, IN (e.publicacoes) p WHERE e.premios > 3 GROUP BY e.nome";
        List<Object[]> resultado = entityManager.createQuery(jpql).getResultList();
        for (Object[] o : resultado) {
            System.out.println("--------------------------------------------");
            System.out.println(o[0]);
            System.out.println(o[1]);
            System.out.println("--------------------------------------------");
        }
    }

    private static void letraACRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root e = criteria.from(Escritor.class);
        Join<Escritor, Publicacao> escritorPublicacaoJoin = e.join("publicacoes");
        Join<Publicacao, Area> publicacaoAreaJoin = escritorPublicacaoJoin.join("areas");
        criteria.multiselect(e.get("nome"), escritorPublicacaoJoin.get("titulo"), publicacaoAreaJoin.get("nome")).where(builder.equal(e.get("id"), 3));
        entityManager.createQuery(criteria).getResultList();
        for ( Object[] o : entityManager.createQuery(criteria).getResultList()) {
            System.out.println("--------------------------------------------");
            System.out.println(o[0]);
            System.out.println(o[1]);
            System.out.println(o[2]);
            System.out.println("--------------------------------------------");
        }
    }

    private static void letraBCRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Subquery<Area> subquery = criteria.subquery(Area.class);
        Root<Publicacao> p = subquery.from(Publicacao.class);
        Join<Publicacao, Area> publicacaoAreaJoin = p.join("areas");
        Join<Publicacao, Revisor> publicacaoRevisorJoin = p.join("revisor");
        subquery.select(publicacaoAreaJoin).where(builder.equal(publicacaoAreaJoin.get("nome"), "industria"));
        criteria.multiselect(p.get("titulo"), publicacaoRevisorJoin.get("nome")).where(builder.exists(subquery));
        for ( Object[] o : entityManager.createQuery(criteria).getResultList()) {
            System.out.println("--------------------------------------------");
            System.out.println(o[1]);
            System.out.println(o[0]);
            System.out.println("--------------------------------------------");
        }
    }

    private static void letraCCRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Revisor> criteria = builder.createQuery(Revisor.class);
        Root<Revisor> r = criteria.from(Revisor.class);
        Join<Revisor, Publicacao> pJoin = r.join("publicacoes");
        criteria.select(r).where(builder.like(pJoin.get("titulo"), "Java%"));
        for ( Revisor revisor : entityManager.createQuery(criteria).getResultList()) {
            System.out.println(revisor.getNome());
        }
    }

    private static void letraDCRITERIA() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Escritor> r = criteria.from(Escritor.class);
        Join<Escritor, Publicacao> pJoin = r.join("publicacoes");
        criteria.multiselect(r.get("nome"), builder.count(pJoin)).where(builder.greaterThan(r.get("premios"), 3)).groupBy(r.get("nome"));
        for ( Object[] o : entityManager.createQuery(criteria).getResultList()) {
            System.out.println("--------------------------------------------");
            System.out.println(o[0]);
            System.out.println(o[1]);
            System.out.println("--------------------------------------------");
        }
    }





}
