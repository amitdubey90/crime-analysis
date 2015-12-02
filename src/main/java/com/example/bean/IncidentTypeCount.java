package com.example.bean;

public class IncidentTypeCount {
    private int rowId;
    private String type;
    private int count;

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "IncidentTypeCount{" +
                "rowId=" + rowId +
                ", type='" + type + '\'' +
                ", count=" + count +
                '}';
    }
}
