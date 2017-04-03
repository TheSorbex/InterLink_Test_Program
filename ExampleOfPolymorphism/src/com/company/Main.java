package com.company;

import com.sun.org.apache.regexp.internal.RE;

public class Main {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(1,2,3);
        Square square = new Square(5);
        Rectangle rect = new Rectangle(4,5);
        someActions(triangle);
        someActions(square);
        someActions(rect);
    }

    public static void someActions (Figure figure){
        System.out.println(figure.getPerimeter());
        System.out.println(figure.getArea());

    }
}

class Triangle implements Figure{
    private int a,b,c;
    public Triangle(int _a, int _b, int _c){
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }

    public double getPerimeter(){
        return this.a + this.b + this.c;
    }

    public double getArea(){
        double p = this.getPerimeter();

        return Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c));
    }
}

class Square implements Figure{

    private int a;

    public Square(int a){
        this.a = a;
    }

    public double getPerimeter(){
        return this.a*4;
    }

    public double getArea(){
        return this.a*this.a;
    }

}

class Rectangle implements Figure{
    private int a,b;

    public Rectangle(int a, int b){
        this.a = a;
        this.b = b;
    }

    public double getPerimeter(){
        return (a+b)*2;
    }

    public double getArea(){
        return a*b;
    }
}


interface Figure {
    public double getPerimeter();
    public double getArea();
}