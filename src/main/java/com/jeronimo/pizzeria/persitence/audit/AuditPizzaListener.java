package com.jeronimo.pizzeria.persitence.audit;

import com.jeronimo.pizzeria.PizzeriaApplication;
import com.jeronimo.pizzeria.persitence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditPizzaListener {

    private PizzaEntity currentValue;

    @PostLoad
    public void postLoad(PizzaEntity pizza) {
        System.out.println("Post load");
        this.currentValue = SerializationUtils.clone(pizza);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity pizza) {
        System.out.println("Post persist or update");
        System.out.println("Old value: " + this.currentValue.toString());
        System.out.println("New value: " + this.currentValue.toString());
    }

    @PreRemove
    public void onPreDelete(PizzaEntity pizza) {
        System.out.println(pizza.toString());
    }

}
