package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.model.Appointments;
import org.hibernate.bytecode.enhance.internal.bytebuddy.EnhancerImpl;

import java.util.Optional;

public class AppointmentsRepository {

    public void createAppointment(EntityManager em, Appointments appointments){

        em.getTransaction().begin();
        em.persist(appointments);
        em.getTransaction().commit();

    }

    public Optional<Appointments> readAppointment(EntityManager em, String id){
        Appointments appointments = em.find(Appointments.class, id);
        return Optional.ofNullable(appointments);
    }

    public void updateAppointment(EntityManager em, Appointments appointments){
        em.getTransaction().begin();
        em.merge(appointments);
        em.getTransaction().commit();
    }

    public void deleteAppointment(EntityManager em, Appointments appointments){
        em.getTransaction().begin();
        em.remove(appointments);
        em.getTransaction().commit();
    }








}
