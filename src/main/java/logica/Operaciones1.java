/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;

/**
 *
 * @author Dora
 */
public interface Operaciones1<P> {
    public int insertar(P dato);
    public List<P> consultar ();
    public P consultar (Long Id);
}

