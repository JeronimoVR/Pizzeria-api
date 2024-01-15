package com.jeronimo.pizzeria.persitence.repository;

import com.jeronimo.pizzeria.persitence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {

}
