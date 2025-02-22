package org.example.tiendaonline.Service;

import java.util.List;

public interface ICRUD<T, ID> {
    List<T> obtener();
    T insertar(T t);
    T actualizar(T t);
    T obtenerUno(ID id);
    void eliminar(ID id);
}
