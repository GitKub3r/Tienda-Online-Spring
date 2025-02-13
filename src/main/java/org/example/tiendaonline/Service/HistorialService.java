package org.example.tiendaonline.Service;

import org.example.tiendaonline.Modelo.Historial;
import org.example.tiendaonline.Repository.IGenericoRepositorio;
import org.example.tiendaonline.Repository.IHistorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialService extends CRUD<Historial, Integer> implements IHistorialService{

    @Autowired
    private IHistorialRepo repo;

    @Override
    protected IGenericoRepositorio<Historial, Integer> getRepo() {
        return repo;
    }
}
