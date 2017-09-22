package com.example.yurifarias.estaqueamento.estacas;

public class Estacas {

    private double posX;
    private double posY;
    private double posZ;
    private double angCrav;
    private double angProj;

    public Estacas(double x, double y, double z, double alfa, double gama) {

        posX = x;
        posY = y;
        posZ = z;
        angCrav = alfa;
        angProj = gama;
    }


    public double getPosX(){
        return posX;
    }

    public double getPosY(){
        return posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public double getAngCrav() {
        return angCrav;
    }

    public double getAngProj() {
        return angProj;
    }

}