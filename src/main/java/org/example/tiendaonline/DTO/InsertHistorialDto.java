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
    private int id;
    private int cliente;
    private int producto;
    private LocalDate fecha_compra;
    private Integer cantidad;
    private String tipo;
    private String descripcion;
}
