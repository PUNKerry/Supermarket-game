package com.punkerry.auxiliarytypes;

public class MyDate implements ShopCalendar {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    @Override
    public int getYear() {
        return year;
    }
    @Override
    public int getMonth() {
        return month;
    }
    @Override
    public int getDay() {
        return day;
    }

    @Override
    public void updateTime() {
        day++;
        if(day>30) {
            day = 1;
            month++;
        }
        if(month>12) {
            month = 1;
            year++;
        }
    }
}
