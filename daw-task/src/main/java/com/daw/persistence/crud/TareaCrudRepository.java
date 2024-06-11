package com.daw.persistence.crud;

import com.daw.persistence.entities.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface TareaCrudRepository extends CrudRepository<Tarea, Integer> {

    
}
