package model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimaRepository extends CrudRepository<Clima, String> {

}
