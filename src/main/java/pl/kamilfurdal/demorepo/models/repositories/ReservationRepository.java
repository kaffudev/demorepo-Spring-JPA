package pl.kamilfurdal.demorepo.models.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kamilfurdal.demorepo.models.ReservationModel;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel,Long> {
        ReservationModel findByName(String name);
/*
        List<ReservationModel> findByName(String name);
        ReservationModel findByNameAndLastname(String name, String lastname);
        List<ReservationModel> findByLastnameContaining(String text);
        List<ReservationModel> findByIdGreaterThan(int howMany);
        List<ReservationModel> findByDateAfter(LocalDate date);*/

        boolean existsByDateEquals(LocalDate date);
        Page<ReservationModel> findByDateIsBetween(LocalDate date1, LocalDate date2, Pageable page);
        Page<ReservationModel> findAll(Pageable page);
        List<ReservationModel> findByLastname(String lastname);


}
