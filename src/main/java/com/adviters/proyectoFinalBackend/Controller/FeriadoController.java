package com.adviters.proyectoFinalBackend.Controller;

import com.adviters.proyectoFinalBackend.Model.Calendar.Feriado;
import com.adviters.proyectoFinalBackend.Model.Users.Usuario;
import com.adviters.proyectoFinalBackend.Repositorys.FeriadoRepository;
import com.adviters.proyectoFinalBackend.Services.FeriadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping ("v1/feriado")
public class FeriadoController {

    @Autowired
    private FeriadoService feriadoService;

    @GetMapping
    public ResponseEntity<Object> getAllHolidays(){
        return ResponseEntity.ok(feriadoService.getAllHolidays());
    }

    @PostMapping
    public ResponseEntity<Object> createHoliday(@RequestBody Feriado feriado){
        try {

            if (feriado.getId() != null) throw new Exception();

            Feriado feriadoGuardado = feriadoService.createHoliday(feriado);

            Map<String, Object> response = new HashMap<>();
            response.put("id", feriadoGuardado.getId());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {

            //CHECK IF ERROR IS FOR ALREADY USED EMAIL
            if (e.getCause().getCause().getMessage().contains("Ya existe la llave (date)")){
                Map<String, Object> map = new HashMap<>();
                map.put("message", "Ya existe un feriado en esa fecha.");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(map);
            }
            if (e.getCause().getCause().getMessage().contains("Ya existe la llave (descripcion)")){
                Map<String, Object> map = new HashMap<>();
                map.put("message", "Ya hay un feriado con ese nombre.");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(map);
            }


            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping (value = "{id}")
    public ResponseEntity<Object> deleteHoliday(@PathVariable("id") Integer holidayId){
        try {
            feriadoService.deleteHoliday(holidayId);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Feriado eliminado correctamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
