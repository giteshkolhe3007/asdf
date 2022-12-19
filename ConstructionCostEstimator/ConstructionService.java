package com.service;

import org.springframework.stereotype.Service;

import com.model.Construction;

@Service
public class ConstructionService {

public double calculateConstructionCost(Construction obj)
{
double totalCost=0.0;
if(obj.getBricksType().equalsIgnoreCase("UnburntClayBricks"))
{
obj.setCostPerSqFt(340.00);
totalCost=obj.getBuildupArea() * obj.getCostPerSqFt();
}
else if(obj.getBricksType().equalsIgnoreCase("BurntClayBricks"))
{
obj.setCostPerSqFt(390.00);
totalCost=obj.getBuildupArea() * obj.getCostPerSqFt();
}
else
{
obj.setCostPerSqFt(300.00);
totalCost=obj.getBuildupArea() * obj.getCostPerSqFt();
}
return totalCost;
}

}
