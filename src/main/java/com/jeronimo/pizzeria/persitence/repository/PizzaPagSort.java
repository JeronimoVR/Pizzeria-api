package com.jeronimo.pizzeria.persitence.repository;

import com.jeronimo.pizzeria.persitence.entity.PizzaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface PizzaPagSort extends ListPagingAndSortingRepository<PizzaEntity,Integer> {

    Page<PizzaEntity> findByAvailableTrue(Pageable pageable);

}
