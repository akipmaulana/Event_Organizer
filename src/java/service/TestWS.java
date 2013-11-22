/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Akip Maulana
 */
@WebService(serviceName = "TestWS")
public class TestWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "baca")
    public String baca(@WebParam(name = "teks") String teks) {
        //TODO write your implementation code here:
        return "BACA " + teks + " !";
    }
}
