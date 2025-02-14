package org.example.tiendaonline.DTO;

import lombok.*;
import org.example.tiendaonline.Modelo.Cliente;
import org.example.tiendaonline.Modelo.Historial;
import org.example.tiendaonline.Modelo.Producto;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistorialDto {
    private int id;
    private Cliente cliente;
    private Producto producto;
    private LocalDate fecha_compra;
    private Integer cantidad;
    private String tipo;
    private String descripcion;

    public Historial historialCast() {
        Historial historial = new Historial();
        historial.setId(id);
        historial.setCliente(cliente);
        historial.setProducto(producto);
        historial.setFechaCompra(fecha_compra);
        historial.setCantidad(cantidad);
        historial.setTipo(tipo);
        historial.setDescripcion(descripcion);
        return historial;
    }

    public HistorialDto castHistorialADto(Historial historial) {
        id = historial.getId();
        cliente = historial.getCliente();
        producto = historial.getProducto();
        fecha_compra = historial.getFechaCompra();
        cantidad = historial.getCantidad();
        tipo = historial.getTipo();
        descripcion = historial.getDescripcion();
        return this;
    }
}
