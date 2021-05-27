/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.controladores;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author freet
 * @param <T>
 */
@Local
public interface ControladorDAO<T> {

    public boolean crear(T entity);

    public boolean editar(T entity);

    public T consultar(int id);

    public String consultar();

    public List<T> condultarEntities();

    public int condultarUltimoRegistro();
}
