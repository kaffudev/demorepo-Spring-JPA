package pl.kamilfurdal.demorepo.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import pl.kamilfurdal.demorepo.models.forms.ReservationForm;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "reservation")
@NoArgsConstructor
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Column(name = "dataname")
    private String name;
    private String lastname;
    private LocalDate date;
    private String adres;

    public ReservationModel(ReservationForm form) {
        name = form.getName();
        lastname = form.getLastname();
        date = form.getFormatedDate();
        adres = form.getAdres();


    }
}
