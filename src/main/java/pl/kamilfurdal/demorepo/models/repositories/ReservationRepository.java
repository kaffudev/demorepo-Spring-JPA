package pl.kamilfurdal.demorepo.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kamilfurdal.demorepo.models.ReservationModel;


@Repository
public interface ReservationRepository extends CrudRepository<ReservationModel,Long> {


}
