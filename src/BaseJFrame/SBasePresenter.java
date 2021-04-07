/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseJFrame;

import BaseDeDatos.AdminDataBase;

/**
 *
 * @author Lenovo
 */
public class SBasePresenter <V extends SBInterface.Vista> implements SBInterface.Presentador{
    protected V vista;
    
    protected AdminDataBase adminDataBase;
    
    public SBasePresenter(V vista) {
        this.vista = vista;
            adminDataBase = new AdminDataBase();
    }
}
