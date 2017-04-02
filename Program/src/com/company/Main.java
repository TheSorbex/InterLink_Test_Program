package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	Frigate Aurora = new Frigate("Аврора", 5, "Фрегат",2);
	Cruiser Zeus = new Cruiser("Зевс", 10, "Крейсер",4);
	TransportShip Prometheus = new TransportShip("Прометей", 5, "Транспортер",5);
        ArrayList<Frigate> ships = new ArrayList<Frigate>();
        ships.add(Aurora);
        ships.add(Zeus);
        ships.add(Prometheus);

        for (Frigate s : ships){
            System.out.println(s.toString());
            s.move();
            s.setFuel(4);
            if (s instanceof Cruiser){
                Cruiser a = (Cruiser) s;
                a.shields();
                a.shoot();
            }
            if (s instanceof TransportShip) {
                TransportShip a = (TransportShip) s;
                a.getPassengers();
            }
        }


    }
}
class Frigate implements LightShip{
    private int speed;
    private String name;
    private String typeOfShip;
    private int maxCapacityOfFuel = 10;
    private int currentCapacityOfFuel;
    private int wasteOfFuel;

    public Frigate(String name,int speed, String typeOfShip, int wasteOfFuel){
        this.name = name;
        this.speed = speed;
        this.typeOfShip = typeOfShip;
        this.currentCapacityOfFuel = this.maxCapacityOfFuel;
        this.wasteOfFuel = wasteOfFuel;
    }

    public void move(){
        if (this.currentCapacityOfFuel>0){
            this.currentCapacityOfFuel-=this.wasteOfFuel;
            System.out.println(this.getTypeOfShip() + " " + this.getName() +  " пролетел " + this.getSpeed() + " световых лет");
        }
    }

    public void setFuel(int a){
        if (this.currentCapacityOfFuel == this.maxCapacityOfFuel){
            System.out.println("Невозможно заполнить бак");
        } else if (this.maxCapacityOfFuel <= (this.currentCapacityOfFuel + a)){
            this.currentCapacityOfFuel = this.maxCapacityOfFuel;
            System.out.println("Бак заполнен полностью");
        } else {
            currentCapacityOfFuel +=a;
            System.out.println("Бак заполнен на " + a + " литров космического топлива");
        }
    }

    public int getFuel(){
        return this.currentCapacityOfFuel;
    }

    public String getName(){
        return this.name;
    }

    public int getSpeed(){
        return this.speed;
    }

    public String getTypeOfShip(){
        return this.typeOfShip;
    }

    public String toString(){
        return this.getTypeOfShip() + " " + this.getName();
    }
}
class Cruiser extends Frigate implements WarShip{
    private boolean shield;
    private int maxCapacityOfFuel = 20;

    public Cruiser(String name, int speed, String typeOfShip, int wasteOfFuel){
        super(name, speed, typeOfShip,wasteOfFuel);
        this.shield = false;

    }


    public void shoot(){
        System.out.println(this.getTypeOfShip() + " " + this.getName() + " произвел выстрел");
    }

    public void shields(){
        if (this.shield){
            this.shield = false;
            System.out.println(this.getTypeOfShip() + " " + this.getName() + " опустил щиты");
        } else {
            this.shield = true;
            System.out.println(this.getTypeOfShip() + " " + this.getName() + " поднял щиты");
        }
    }

}

class TransportShip extends Frigate implements HeavyShip {
    private boolean passengers;

    public TransportShip (String name, int speed, String typeOfShip,int wasteOfFuel){
        super(name,speed,typeOfShip,wasteOfFuel);
        this.passengers = false;
    }

    public void getPassengers() {
        if (!this.passengers){
            this.passengers = true;
            System.out.println(this.getTypeOfShip() +" "+ this.getName() + " набрал пассажиров");
        } else {
            this.passengers = false;
            System.out.println(this.getTypeOfShip() +" "+ this.getName() + " высадил пассажиров");
        }
    }
}
interface LightShip{
    void move();
    void setFuel(int a);
    String getName();
    int getSpeed();
    int getFuel();
    String getTypeOfShip();
}

interface WarShip extends  LightShip{
    void shoot();
    void shields();
}

interface HeavyShip  extends LightShip{
    void getPassengers();
}