package com.daw.services.dto;

import com.daw.persistence.entities.Tarea;
import com.daw.persistence.entities.enums.Estado;
import com.daw.persistence.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> getTareas(){
        return this.tareaRepository.findAll();
    }
    public Optional<Tarea> getTarea(int idTarea){
       return this.tareaRepository.findById(idTarea);
    }

    public Tarea crearTarea(Tarea tarea){
        tarea.setEstado(Estado.PENDIENTE);
        tarea.setFechaCreacion(LocalDate.now());

        return this.tareaRepository.save(tarea);
    }

    public Tarea actualizarTarea(Tarea tarea){
        return this.tareaRepository.save(tarea);
    }

    public boolean borrarTarea(int idTarea){
        boolean result = false;

        if((this.tareaRepository.findById(idTarea).isPresent())){
            this.tareaRepository.deleteById(idTarea);
            result = true;
        }
    return result;
    }

    public List<Tarea> getTareasEmpiezanPorP(String titulo){
        return this.tareaRepository.findByTituloStartingWith(titulo);
    }

    public List<Tarea> getTareasIdMayorQue4(int idTarea){
        return this.tareaRepository.findByIdGreaterThan(idTarea);
    }

    public List<Tarea> getTareasPendientes() {
        return this.tareaRepository.findByEstado(Estado.PENDIENTE);
    }

    public List<Tarea> getTareasEnProgreso() {
        return this.tareaRepository.findByEstado(Estado.EN_PROGRESO);
    }

    public List<Tarea> getTareasCompletadas() {
        return this.tareaRepository.findByEstado(Estado.COMPLETADA);
    }

    public List<Tarea> getTareasVencidas() {
        return this.tareaRepository.findByFechaVencimientoBefore(LocalDate.now());
    }

    public List<Tarea> getTareasNoVencidas() {
        return this.tareaRepository.findByFechaVencimientoAfter(LocalDate.now());
    }

    public List<Tarea> getTareasTitulo(String titulo) {
        return this.tareaRepository.findByTituloStartingWith(titulo);
    }
}
