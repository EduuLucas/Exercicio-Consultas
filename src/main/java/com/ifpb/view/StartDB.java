package com.ifpb.view;

import com.ifpb.model.*;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StartDB {

    private List<Escritor> escritores = new ArrayList<>();
    private List<Revisor> revisores = new ArrayList<>();
    private List<Area> areas = new ArrayList<>();
    private List<Publicacao> publicacoes = new ArrayList<>();
    private EntityManager em;

    public StartDB(EntityManager em) {
        this.em = em;
    }


    public void addRevisores(){

        revisores.add(new Revisor(4, "Lucas", LocalDate.of(1996, 12, 16),"7.6"));
        revisores.add(new Revisor(5, "Eduardo", LocalDate.of(1995, 04, 23),"7.0"));
        revisores.add(new Revisor(6, "Romero", LocalDate.of(1999, 07, 10),"8.5"));

    }

    public void addEscritores(){

        escritores.add(new Escritor(1, "Paulo", LocalDate.of(1992, 12, 07), 4));
        escritores.add(new Escritor(2, "Roberto", LocalDate.of(1991, 06, 16), 2));
        escritores.add(new Escritor(3, "Muriel", LocalDate.of(1992, 03, 27), 1));

    }

    public void addPublicacoes(){

        addRevisores();
        addEscritores();

        publicacoes.add(new Publicacao(1, "A realidade virtual nos estudos tecnológicos", escritores.get(0), revisores.get(0)));
        publicacoes.add(new Publicacao(2, "A realidade virtual nos estudos da saúde", escritores.get(1), revisores.get(1)));
        publicacoes.add(new Publicacao(3, "A realidade virtual nos estudos da ciência", escritores.get(2), revisores.get(2)));
        publicacoes.add(new Publicacao(4, "A realidade virtual nos estudos da ciência industrial", escritores.get(0), revisores.get(2)));
        publicacoes.add(new Publicacao(5,"Java: Rápido e fácil", escritores.get(1), revisores.get(2)));

    }

    public void addAreas(){

        addPublicacoes();

        areas.add(new Area(1, "tecnologia", publicacoes.get(0)));
        areas.add(new Area(2, "saúde", publicacoes.get(1)));
        areas.add(new Area(3, "ciência", publicacoes.get(2)));
        areas.add(new Area(4, "industria", publicacoes.get(3)));

    }

    public void Inicia() {

        addAreas();

        em.getTransaction().begin();

        for (Revisor revisor : revisores) {
            em.persist(revisor);
        }
        for (Escritor escritor : escritores) {
            em.persist(escritor);
        }
        for(Area area : areas){
            em.persist(area);
        }
        for(Publicacao publicacao : publicacoes){
            em.persist(publicacao);
        }
        em.getTransaction().commit();


    }




}
