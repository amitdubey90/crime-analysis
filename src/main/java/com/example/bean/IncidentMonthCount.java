package com.example.bean;

public class IncidentMonthCount {
    private int rowId;
    private int month;
    private int year;
    private int count;

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "IncidentMonthCount{" +
                "rowId=" + rowId +
                ", month=" + month +
                ", year=" + year +
                ", count=" + count +
                '}';
    }
}
