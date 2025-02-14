package org.example.tiendaonline.Service;

import org.example.tiendaonline.Modelo.Historial;
import org.example.tiendaonline.Modelo.Producto;
import org.example.tiendaonline.Repository.IGenericoRepositorio;
import org.example.tiendaonline.Repository.IHistorialRepo;
import org.example.tiendaonline.Repository.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends CRUD<Producto, Integer> implements IProductoService{
    @Autowired
    private IProductoRepo repo;

    @Override
    protected IGenericoRepositorio<Producto, Integer> getRepo() {
        return repo;
    }
}
