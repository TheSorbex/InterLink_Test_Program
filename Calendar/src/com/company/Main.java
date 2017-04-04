package com.company;

import java.time.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();

        drawCalendar(d);
    }

    public static void drawCalendar(){
        LocalDate now = LocalDate.now();
        drawCalendar(now.getMonth().getValue());
    }

    public static void drawCalendar(int month){
        if (month<0 || month>12){
            drawCalendar();
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDate date = LocalDate.of(2017,month,1);
        System.out.println(date.getMonth());
        System.out.println("Mo Tu We Th Fr " + (char)27 + "[31mSa Su" + (char)27+"[0m");
        for (int i = 1; i<date.getDayOfWeek().getValue(); i++){
            System.out.print("   ");
        }

        for (int i = date.getDayOfWeek().getValue(); i < date.getMonth().minLength()+date.getDayOfWeek().getValue(); i++) {
            if (date.getMonth() == now.getMonth()) {
                if (i - date.getDayOfWeek().getValue() + 1 != now.getDayOfMonth()) {
                    if (i%7!=6 && i%7!=0) {
                        if (i - date.getDayOfWeek().getValue() + 1 < 10) {
                            System.out.print(i - date.getDayOfWeek().getValue() + 1 + "  ");
                        } else {
                            System.out.print(i - date.getDayOfWeek().getValue() + 1 + " ");
                        }
                    } else {
                        if (i - date.getDayOfWeek().getValue() + 1 < 10) {
                            System.out.print((char) 27 + "[31m" + (i - date.getDayOfWeek().getValue() + 1) + (char) 27 + "[0m  ");
                        } else {
                            System.out.print((char) 27 + "[31m" + (i - date.getDayOfWeek().getValue() + 1) + (char) 27 + "[0m ");
                        }
                    }
                } else {
                    if (i - date.getDayOfWeek().getValue() + 1 < 10) {
                        System.out.print((char) 27 + "[34m" + (i - date.getDayOfWeek().getValue() + 1) + (char) 27 + "[0m  ");
                    } else {
                        System.out.print((char) 27 + "[34m" + (i - date.getDayOfWeek().getValue() + 1) + (char) 27 + "[0m ");
                    }
                }
                } else {
                if (i%7!=6 && i%7!=0) {
                    if (i - date.getDayOfWeek().getValue() + 1 < 10) {
                        System.out.print(i - date.getDayOfWeek().getValue() + 1 + "  ");
                    } else {
                        System.out.print(i - date.getDayOfWeek().getValue() + 1 + " ");
                    }
                } else {
                    if (i - date.getDayOfWeek().getValue() + 1 < 10) {
                        System.out.print((char) 27 + "[31m" + (i - date.getDayOfWeek().getValue() + 1) + (char) 27 + "[0m  ");
                    } else {
                        System.out.print((char) 27 + "[31m" + (i - date.getDayOfWeek().getValue() + 1) + (char) 27 + "[0m ");
                    }
                }
            }
            if (i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();

    }
}
