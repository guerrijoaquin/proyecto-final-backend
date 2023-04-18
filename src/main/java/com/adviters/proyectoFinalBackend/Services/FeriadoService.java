package com.adviters.proyectoFinalBackend.Services;

import com.adviters.proyectoFinalBackend.Model.Calendar.Feriado;
import com.adviters.proyectoFinalBackend.Repositorys.FeriadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeriadoService {


    @Autowired
    private FeriadoRepository feriadoRepository;

    public List<Feriado> getAllHolidays(){
        return feriadoRepository.findAll();
    }

    public Feriado createHoliday(Feriado feriado){
        return feriadoRepository.save(feriado);
    }

    public void deleteHoliday(Integer holidayId) {
        feriadoRepository.deleteById(holidayId);
    }
}
