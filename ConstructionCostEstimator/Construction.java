package com.model;

import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Component
public class Construction {

private String bricksType;
@Min(value=500, message="Buildup Area should be minimum 500")
private double buildupArea;
private double costPerSqFt;

public String getBricksType() {
return bricksType;
}
public void setBricksType(String bricksType) {
this.bricksType = bricksType;
}
public double getBuildupArea() {
return buildupArea;
}
public void setBuildupArea(double buildupArea) {
this.buildupArea = buildupArea;
}
public double getCostPerSqFt() {
return costPerSqFt;
}
public void setCostPerSqFt(double costPerSqFt) {
this.costPerSqFt = costPerSqFt;
}



}
