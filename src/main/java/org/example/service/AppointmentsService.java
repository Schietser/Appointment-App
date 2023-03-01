package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.connection.EntityManagerProvider;
import org.example.model.Appointments;
import org.example.repository.AppointmentsRepository;

import java.util.Optional;

public class AppointmentsService {

    private AppointmentsRepository appointmentsRepository = new AppointmentsRepository();


    public void createAppointment(Appointments appointments){
        EntityManager em = EntityManagerProvider.getEntityManager();
        appointmentsRepository.createAppointment(em, appointments);
        em.close();
    }

    public Optional<Appointments> readAppointment(String id){
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Appointments> optionalAppointment = appointmentsRepository.readAppointment(em, id);
        em.close();
        return optionalAppointment;
    }

    public void deleteAppointment(String id){
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Appointments> optionalAppointments = appointmentsRepository.readAppointment(em, id);

        if (optionalAppointments.isPresent()){
            appointmentsRepository.deleteAppointment(em, optionalAppointments.get());
        }
        em.close();
    }

    public void updateAppointment(Appointments appointments){
        EntityManager em = EntityManagerProvider.getEntityManager();
        appointmentsRepository.updateAppointment(em,appointments);
    }



}
