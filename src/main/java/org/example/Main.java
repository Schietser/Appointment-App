package org.example;

import org.example.model.Appointments;
import org.example.repository.AppointmentsRepository;
import org.example.service.AppointmentsService;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Appointments appointment1 = new Appointments("Meeting","A meeting about meetings",28,2,2023,14,30);
        Appointments appointment2 = new Appointments("Another meeting","A meeting about the meeting of meetings",1,3,2023,10,0);
        Appointments appointment3 = new Appointments("Yet another meeting","A meeting about the meeting about the meeting of meetings",2,3,2023,11,30);

        AppointmentsService appointmentsService = new AppointmentsService();

        appointmentsService.createAppointment(appointment1);
        appointmentsService.createAppointment(appointment2);
        appointmentsService.createAppointment(appointment3);

        Optional<Appointments> appointmentsdb = appointmentsService.readAppointment("1-3-2023-10-0");
        if (appointmentsdb.isPresent()){
            System.out.println(appointmentsdb.get());
        } else {
            System.out.println("No meeting with that id found");
        }

        appointmentsService.deleteAppointment("28_2_2023_30_14");

        Optional<Appointments> appointmentToUpdate = appointmentsService.readAppointment("28-2-2023-30-14");

        if (appointmentToUpdate.isPresent()){
            Appointments foundAppointment = appointmentToUpdate.get();
            foundAppointment.setDay(30);
            foundAppointment.setTitle("Meeting that has been edited");
            appointmentsService.updateAppointment(foundAppointment);
        }
    }
}
