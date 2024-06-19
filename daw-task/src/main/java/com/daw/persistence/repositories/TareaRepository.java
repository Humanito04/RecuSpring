package com.daw.persistence.repositories;

import com.daw.persistence.crud.TareaCrudRepository;
import com.daw.persistence.entities.Tarea;
import com.daw.persistence.entities.enums.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class TareaRepository {

    @Autowired
    private TareaCrudRepository tareaCrudRepository;

    public List<Tarea> findAll(){
        return (List<Tarea>) this.tareaCrudRepository.findAll();
    }

    public Optional<Tarea> findById(int idTarea){
        return this.tareaCrudRepository.findById(idTarea);
    }

    public Tarea save(Tarea tarea){
        return this.tareaCrudRepository.save(tarea);
    }

    public void deleteById(int idTarea){
        this.tareaCrudRepository.deleteById(idTarea);
    }
    public List<Tarea> findByTituloStartingWith(String titulo){
        return this.tareaCrudRepository.findByTituloStartingWith(titulo);
    }

    public List<Tarea> findByIdGreaterThan(int id){
        return this.tareaCrudRepository.findByIdGreaterThan(id);
    }


    public List<Tarea> findByEstado(Estado estado) {
        return this.tareaCrudRepository.findByEstado(estado);
    }


    public List<Tarea> findByFechaVencimientoBefore(LocalDate date) {
        return this.tareaCrudRepository.findByFechaVencimientoBefore(date);
    }

    public List<Tarea> findByFechaVencimientoAfter(LocalDate date) {
        return this.tareaCrudRepository.findByFechaVencimientoAfter(date);
    }

}
