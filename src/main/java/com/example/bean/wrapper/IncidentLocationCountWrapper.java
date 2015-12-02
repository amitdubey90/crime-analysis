package com.example.bean.wrapper;

import java.util.List;

import com.example.bean.IncidentLocationCount;

public class IncidentLocationCountWrapper {
 List<IncidentLocationCount> location ;

public List<IncidentLocationCount> getLocation() {
	return location;
}

public void setLocation(List<IncidentLocationCount> location) {
	this.location = location;
}

public IncidentLocationCountWrapper(List<IncidentLocationCount> location) {
	this.location = location;
}


	
}
