package com.daw.web.controller;

import com.daw.persistence.entities.Tarea;
import com.daw.services.dto.TareaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public ResponseEntity<List<Tarea>> listAll(){
        return ResponseEntity.ok(this.tareaService.getTareas());
    }

    @GetMapping("/{idTarea}")
    public ResponseEntity<Tarea> findOne( @PathVariable int idTarea){
        Optional<Tarea> tarea = this.tareaService.getTarea(idTarea);
         if( tarea.isPresent()){
             return ResponseEntity.ok(tarea.get());
         }else{
             return ResponseEntity.notFound().build();
         }
    }

    @PostMapping
    public ResponseEntity<Tarea> create(@RequestBody Tarea tarea){
        return new ResponseEntity<Tarea>(this.tareaService.crearTarea(tarea), HttpStatus.CREATED);
    }

    @PutMapping("/{idTarea}")
    public ResponseEntity<Tarea> update(@RequestBody Tarea tarea, @PathVariable int idTarea){
        if(idTarea == tarea.getId()){
            if(this.tareaService.getTarea(idTarea).isPresent()){
                return ResponseEntity.ok(this.tareaService.actualizarTarea(tarea));
            }else{
                return ResponseEntity.notFound().build();
            }

        }else{
            return ResponseEntity.badRequest().build();
        }

    }
    @DeleteMapping("/{idTarea}")
    public ResponseEntity<Tarea> delete (@PathVariable int idTarea){
        if(this.tareaService.borrarTarea(idTarea)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/empiezan")
    public ResponseEntity<List<Tarea>> empiezanP(@RequestParam String titulo){
        return  ResponseEntity.ok(this.tareaService.getTareasEmpiezanPorP(titulo));
    }

    @GetMapping("/mayores")
    public ResponseEntity<List<Tarea>> mayores4(@RequestParam int idTarea){
        return ResponseEntity.ok(this.tareaService.getTareasIdMayorQue4(idTarea));
    }


    @GetMapping("/pendientes")
    public ResponseEntity<List<Tarea>> getTareasPendientes() {
        List<Tarea> tareasPendientes = tareaService.getTareasPendientes();
        if (tareasPendientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tareasPendientes, HttpStatus.OK);
    }


}
