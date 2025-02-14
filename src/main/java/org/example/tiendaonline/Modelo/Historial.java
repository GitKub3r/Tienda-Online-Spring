package org.example.tiendaonline.Modelo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "historial")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Evita proxies de Hibernate
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Carga diferida
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // Carga diferida
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;

    @ColumnDefault("1")
    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipo;

    @Column(name = "descripcion", length = 200)
    private String descripcion;
}
