package com.company;

import java.sql.Time;
import java.time.*;
import java.util.Scanner;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write the number of month that you need to look: ");
        int d = sc.nextInt();
        drawCalendar(d);
    }

    public static void drawCalendar(){
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        drawCalendar(now.getMonth().getValue());
    }

    public static void drawCalendar(int m){
        if (m < 0 || m > 12){
            drawCalendar();
            return;
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
        Month month = Month.of(m);
        LocalDate date = LocalDate.of(now.getYear(),month.getValue(),1);
        DayOfWeek firstDay = DayOfWeek.of(date.getDayOfWeek().getValue());

        System.out.println(month);
        System.out.println("Mo Tu We Th Fr " + (char)27 + "[31mSa Su" + (char)27+"[0m");

        for (int i = 1; i<firstDay.getValue(); i++){
            System.out.print("   ");
        }

        for (int i = firstDay.getValue(); i < month.minLength() + firstDay.getValue(); i++) {
            if (month == now.getMonth()) {
                if (i - firstDay.getValue() + 1 != now.getDayOfMonth()) {
                    if (i%7!=6 && i%7!=0) {
                        writeSimpleDays(i,firstDay);
                    } else {
                        writeWeekends(i,firstDay);
                    }
                } else {
                    writeCurrentDay(i,firstDay);
                }
            } else {
                if (i%7!=6 && i%7!=0) {
                    writeSimpleDays(i,firstDay);
                } else {
                    writeWeekends(i,firstDay);
                }
            }
            if (i % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();

    }

    public static void writeWeekends(int i, DayOfWeek day){
        if (i - day.getValue() + 1 < 10) {
            System.out.print((char) 27 + "[31m" + (i - day.getValue() + 1) + (char) 27 + "[0m  ");
        } else {
            System.out.print((char) 27 + "[31m" + (i - day.getValue() + 1) + (char) 27 + "[0m ");
        }
    }

    public static void writeSimpleDays(int i,DayOfWeek day){
        if (i - day.getValue() + 1 < 10) {
            System.out.print(i - day.getValue() + 1 + "  ");
        } else {
            System.out.print(i - day.getValue() + 1 + " ");
        }
    }

    public static void writeCurrentDay(int i, DayOfWeek day){
        if (i - day.getValue() + 1 < 10) {
            System.out.print((char) 27 + "[34m" + (i - day.getValue() + 1) + (char) 27 + "[0m  ");
        } else {
            System.out.print((char) 27 + "[34m" + (i - day.getValue() + 1) + (char) 27 + "[0m ");
        }
    }
}
