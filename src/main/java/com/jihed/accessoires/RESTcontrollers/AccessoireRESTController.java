package com.jihed.accessoires.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.service.AccessoireService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccessoireRESTController {

	@Autowired
	AccessoireService accessoireService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Accessoire> getAllAccessoire(){
		return accessoireService.getAllAccessoire();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET) 
	public Accessoire getAccessoireById(@PathVariable("id") Long id)
	{  
		return accessoireService.getAccessoire(id); 
	} 
	
	@RequestMapping(method = RequestMethod.POST) 
	public Accessoire createProduit(@RequestBody Accessoire accessoire) 
	{ 
		return accessoireService.saveAccessoire(accessoire); 
	} 
	
	@RequestMapping(method = RequestMethod.PUT) 
	public Accessoire updateAccessoire(@RequestBody Accessoire accessoire) { 
	return accessoireService.updateAccessoire(accessoire); 
	} 
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE) 
	public void deleteAccessoire(@PathVariable("id") Long id) 
	{ 
		accessoireService.deleteAccessoireById(id); 
	} 
	
	@RequestMapping(value="/accessmar/{idMar}",method = RequestMethod.GET) 
	public List<Accessoire> getAccessoireByMarId(@PathVariable("idMar") Long idMar) { 
	return accessoireService.findByMarqueIdMar(idMar); 
	}
	
}
