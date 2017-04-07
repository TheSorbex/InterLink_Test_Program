package com.company;

import java.time.*;
import java.util.Scanner;

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

        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        Month month = Month.of(m);
        int currentMonthCapacity;
        LocalDate date = LocalDate.of(now.getYear(), month.getValue(),1);

        if (date.getYear()%4 == 0){
            currentMonthCapacity = month.maxLength();
        } else {
            currentMonthCapacity = month.minLength();
        }
        DayOfWeek firstDay = DayOfWeek.of(date.getDayOfWeek().getValue());

        System.out.println(month);
        System.out.println("Mo Tu We Th Fr " + (char)27 + "[31mSa Su" + (char)27+"[0m");

        for (int i = DayOfWeek.MONDAY.getValue(); i < firstDay.getValue(); i++){
            System.out.print("   ");
        }

        for (int i = firstDay.getValue(); i < currentMonthCapacity + firstDay.getValue(); i++) {
            writeDay(i,firstDay,month);
        }
        System.out.println();
    }

    public static void writeDay(int i, DayOfWeek day, Month month){
        String color;
        String spaces;

        if (i-day.getValue() + 1 < 10){
            spaces = "  ";
        } else {
            spaces = " ";
        }

        if (LocalDate.now().getMonth() == month && i - day.getValue() + 1 == LocalDate.now().getDayOfMonth()){
            color = "34";
        } else if(i % 7 != 6 && i % 7 != 0){
            color = "30";
        } else {
            color = "31";
        }
        System.out.print((char) 27 + "[" + color + "m"  +(i - day.getValue() + 1) + (char) 27 + "[0m" + spaces);

        if (i % 7 == 0) {
            System.out.println();
        }
    }
}
