package model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperaturaRepository extends CrudRepository<Temperatura, String> {

}