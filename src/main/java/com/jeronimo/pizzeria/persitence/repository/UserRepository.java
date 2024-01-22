package com.jeronimo.pizzeria.persitence.repository;

import com.jeronimo.pizzeria.persitence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,String> {
}
