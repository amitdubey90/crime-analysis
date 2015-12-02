package com.example.bean;

public class IncidentLocationCount {
	
	private int rowId;
	private long latitude;
    private long longitude;
    private long count;
	public int getRowId() {
		return rowId;
	}
	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	
    public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "IncidentLocationCount [rowId=" + rowId + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", count=" + count + "]";
	}
	
}
