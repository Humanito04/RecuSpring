package com.daw.persistence.crud;

import com.daw.persistence.entities.Tarea;
import com.daw.persistence.entities.enums.Estado;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TareaCrudRepository extends CrudRepository<Tarea, Integer> {

    List<Tarea> findByTituloStartingWith(String titulo);
    List<Tarea> findByIdGreaterThan(int id);
    List<Tarea> findByEstado(Estado estado);
    List<Tarea> findByFechaVencimientoBefore(LocalDate fecha);
    List<Tarea> findByFechaVencimientoAfter(LocalDate fecha);
}

