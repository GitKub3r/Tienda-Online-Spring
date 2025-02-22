package org.example.tiendaonline.Controler;

import jakarta.validation.Valid;
import org.example.tiendaonline.DTO.HistorialDto;
import org.example.tiendaonline.DTO.InsertHistorialDto;
import org.example.tiendaonline.Modelo.Cliente;
import org.example.tiendaonline.Modelo.Historial;
import org.example.tiendaonline.Modelo.Producto;
import org.example.tiendaonline.Service.IClienteService;
import org.example.tiendaonline.Service.IHistorialService;
import org.example.tiendaonline.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialControler {

    @Autowired
    private IHistorialService servicio;

    @Autowired
    private IClienteService clienteService;

    @Autowired
    private IProductoService productoService;

    @GetMapping
    public ResponseEntity<List<HistorialDto>> obtenerTodos() {
        List<Historial> historialBBDD = servicio.obtener();
        List<HistorialDto> listaHistorialDto = new ArrayList<>();

        for (Historial historial: historialBBDD) {
            HistorialDto destinosDto = new HistorialDto();
            listaHistorialDto.add(destinosDto.castHistorialADto(historial));
        }
        return new ResponseEntity<>(listaHistorialDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialDto> obtenerById(@PathVariable(name = "id") Integer id) {
        Historial historialBBDD = servicio.obtenerUno(id);
        HistorialDto historialDto = new HistorialDto();
        historialDto.castHistorialADto(historialBBDD);
        return new ResponseEntity<>(historialDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity insertar(@Valid @RequestBody InsertHistorialDto insertHistorialDto) {
        Historial historial = insertHistorialDto.historialCast();
        Cliente cliente = servicio.obtenerUno(insertHistorialDto.getCliente()).getCliente();
        historial.setCliente(cliente);
        Producto producto = servicio.obtenerUno(insertHistorialDto.getProducto()).getProducto();
        historial.setProducto(producto);
        String texto = servicio.insertar1(historial);
        switch (texto) {
            case "ok":
                return ResponseEntity.status(HttpStatus.OK).body("Compra procesada corractamente");
            case "stock":
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Stock insuficiente: Solo quedan " + producto.getStock() + " unidades disponibles");
            case "dias":
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Han pasado más de 30 días desde la compra");
            default:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Tipo de historial incorrecto");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsertHistorialDto> update(@Valid @RequestBody InsertHistorialDto insertHistorialDto, @PathVariable(name = "id") Integer id) {
        Historial historial = insertHistorialDto.historialCast1(id);
        Cliente cliente = clienteService.obtenerUno(insertHistorialDto.getCliente());
        historial.setCliente(cliente);
        Producto producto = productoService.obtenerUno(insertHistorialDto.getProducto());
        historial.setProducto(producto);
        servicio.actualizar(historial);
        return new ResponseEntity<>(insertHistorialDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        servicio.eliminar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
