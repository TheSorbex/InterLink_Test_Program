package com.company;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ValueRange;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write the number of month that you need to look: ");
        try {
            int d = sc.nextInt();
            drawCalendar(d);
        } catch (Exception e){
            System.out.println("Invalid input");
            drawCalendar();
        }
    }

    public static void drawCalendar(){
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        drawCalendar(now.getMonth().getValue());
    }

    public static void drawCalendar(int m){
        TextStyle text = TextStyle.SHORT;
        Locale locale = Locale.ENGLISH;

        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        LocalDate date = LocalDate.of(now.getYear(), m, 1);

        DayOfWeek firstDay = DayOfWeek.of(date.getDayOfWeek().getValue());

        System.out.println(Month.of(m));
        for (DayOfWeek day : DayOfWeek.values()){
            String color;
            if (day.getValue()<DayOfWeek.SATURDAY.getValue()) {
                color = "30";
            } else {
                color = "31";
            }
            System.out.print((char)27 + "[" + color + "m" + day.getDisplayName(text, locale) + (char)27 + "[0m ");
        }

        System.out.println();

        for (int i = DayOfWeek.MONDAY.getValue(); i < firstDay.getValue(); i++){
            System.out.print("    ");
        }

        for (int i = firstDay.getValue(); i < date.lengthOfMonth() + firstDay.getValue(); i++) {
            writeDay(i, firstDay, m);
        }
        System.out.println();
    }

    public static void writeDay(int i, DayOfWeek day, int month){
        String color;
        String spaces;

        if (i-day.getValue() + 1 < 10){
            spaces = "   ";
        } else {
            spaces = "  ";
        }

        if (LocalDate.now().getMonth() == Month.of(month) && i - day.getValue() + 1 == LocalDate.now().getDayOfMonth()){
            color = "34";
        } else if(i % 7 < DayOfWeek.SATURDAY.getValue() && i % 7 >= DayOfWeek.MONDAY.getValue()){
            color = "30";
        } else {
            color = "31";
        }
        System.out.print((char) 27 + "[" + color + "m"  +(i - day.getValue() + 1) + (char) 27 + "[0m" + spaces);

        if (i % 7 == DayOfWeek.MONDAY.getValue()-1) {
            System.out.println();
        }
    }
}
