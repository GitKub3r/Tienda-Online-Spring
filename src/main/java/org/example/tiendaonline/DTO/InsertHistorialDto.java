package org.example.tiendaonline.DTO;

import lombok.*;
import org.example.tiendaonline.Modelo.Cliente;
import org.example.tiendaonline.Modelo.Historial;
import org.example.tiendaonline.Modelo.Producto;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InsertHistorialDto {
    private int cliente;
    private int producto;
    private LocalDate fecha_compra;
    private Integer cantidad;
    private String tipo;
    private String descripcion;

    public Historial historialCast() {
        Historial historial = new Historial();
        historial.setFechaCompra(fecha_compra);
        historial.setCantidad(cantidad);
        historial.setTipo(tipo);
        historial.setDescripcion(descripcion);
        return historial;
    }

    public Historial historialCast1(int id) {
        Historial historial = new Historial();
        historial.setId(id);
        historial.setFechaCompra(fecha_compra);
        historial.setCantidad(cantidad);
        historial.setTipo(tipo);
        historial.setDescripcion(descripcion);
        return historial;
    }
}
