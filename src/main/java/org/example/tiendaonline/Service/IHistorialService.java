package org.example.tiendaonline.Service;

import org.example.tiendaonline.Modelo.Historial;

public interface IHistorialService extends ICRUD<Historial,Integer>{
    String insertar1(Historial historial);
}
