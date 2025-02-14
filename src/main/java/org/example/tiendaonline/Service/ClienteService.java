package org.example.tiendaonline.Service;

import org.example.tiendaonline.Modelo.Cliente;
import org.example.tiendaonline.Repository.IClienteRepo;
import org.example.tiendaonline.Repository.IGenericoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends CRUD<Cliente, Integer> implements IClienteService {

    @Autowired
    private IClienteRepo repo;

    @Override
    protected IGenericoRepositorio<Cliente, Integer> getRepo() {
        return repo;
    }
}
