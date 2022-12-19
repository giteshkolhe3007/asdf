package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Construction;
import com.service.ConstructionService;

@Controller
public class ConstructionController {

@Autowired
private ConstructionService service;

@RequestMapping(value = "/estimatorPage", method = RequestMethod.GET)
public String estimatorPage(@ModelAttribute("construction") Construction construction)
{
return "estimatorpage";
}

@ModelAttribute("bricksList")
public Map<String, String> buildState(){

Map<String, String> serviceMap = new HashMap<String, String>();
serviceMap.put("UnburntClayBricks", "UnburntClayBricks");
serviceMap.put("BurntClayBricks", "BurntClayBricks");
serviceMap.put("ConcreteBricks", "ConcreteBricks");
return serviceMap;
}

@RequestMapping(value = "/result", method = RequestMethod.POST)
public String calculateConstructionCost(@Valid @ModelAttribute("construction") Construction construction,
BindingResult result,ModelMap map)
{
if(result.hasErrors()) {
return "estimatorpage";
}
else
{
double cost=service.calculateConstructionCost(construction);
map.addAttribute("cost",cost);
return "result";

}
}



}
