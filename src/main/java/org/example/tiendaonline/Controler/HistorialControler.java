package org.example.tiendaonline.Controler;

import org.example.tiendaonline.DTO.HistorialDto;
import org.example.tiendaonline.Modelo.Historial;
import org.example.tiendaonline.Service.IHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialControler {

    @Autowired
    private IHistorialService servicio;

    @GetMapping
    public ResponseEntity<List<HistorialDto>> obtenerTodos() {
        List<Historial> historialBBDD = servicio.obtener();
        List<HistorialDto> ListaHistorialDto = new ArrayList<>();

        for (Historial historial: historialBBDD) {
            HistorialDto destinosDto = new HistorialDto();
            ListaHistorialDto.add(destinosDto.castHistorialADto(historial));
        }
        return new ResponseEntity<>(ListaHistorialDto, HttpStatus.OK);
    }
}
