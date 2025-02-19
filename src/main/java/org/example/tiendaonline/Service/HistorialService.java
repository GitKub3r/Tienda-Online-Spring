package org.example.tiendaonline.Service;

import org.example.tiendaonline.DTO.HistorialDto;
import org.example.tiendaonline.Modelo.Cliente;
import org.example.tiendaonline.Modelo.Historial;
import org.example.tiendaonline.Modelo.Producto;
import org.example.tiendaonline.Repository.IGenericoRepositorio;
import org.example.tiendaonline.Repository.IHistorialRepo;
import org.example.tiendaonline.Repository.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class HistorialService extends CRUD<Historial, Integer> implements IHistorialService{

    @Autowired
    IHistorialRepo repo;

    @Autowired
    IProductoRepo productoRepo;

    @Override
    protected IGenericoRepositorio<Historial, Integer> getRepo() {
        return repo;
    }

    @Override
    public String insertar1(Historial h) {
        Producto product = h.getProducto();

        switch (h.getTipo()) {
            case "Compra":
                if (product.getStock() < h.getCantidad()) {
                    return "stock";
                } else {
                    repo.save(h);
                    product.setStock(product.getStock() - h.getCantidad());
                    productoRepo.save(product);
                    return "ok";
                }

            case "Devolución":
                long remainDays = ChronoUnit.DAYS.between(h.getFechaCompra(), LocalDate.now());

                if (remainDays > 30) {
                    return "dias";
                } else {
                    repo.save(h);
                    product.setStock(product.getStock() + h.getCantidad());
                    productoRepo.save(product);
                    return "ok";
                }
            default:
                return "incorrecto";
        }
    }
}