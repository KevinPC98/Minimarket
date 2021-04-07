/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseInternalFrame;

import BaseDeDatos.AdminDataBase;
/**
 *
 * @author KevinPC
 */
public class BasePresentador <V extends BaseInterface.BVista> implements BaseInterface.BPresenter{
    protected V vista;
    protected AdminDataBase adminDataBase;
    public BasePresentador(V vista){
       this.vista = vista;
            adminDataBase = new AdminDataBase();
   }
}
