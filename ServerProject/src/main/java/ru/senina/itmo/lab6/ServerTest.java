package ru.senina.itmo.lab6;

import java.util.concurrent.TimeoutException;

public class ServerTest {
    //пример сломаный
    public static void main(String[] args){
        ServerNetConnector net = new ServerNetConnector();
        net.startConnection(8181);
        try {
            net.nextCommand(2000);
        }catch (TimeoutException e){
            net.stopConnection();
            net.startConnection(8181);
        }
        net.sendResponse("abcdefghijkmnlop");
        net.stopConnection();
    }
}
