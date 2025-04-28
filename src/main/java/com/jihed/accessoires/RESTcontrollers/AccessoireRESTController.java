package com.jihed.accessoires.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jihed.accessoires.dto.AccessoireDTO;
import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.service.AccessoireService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AccessoireRESTController {

	@Autowired
	AccessoireService accessoireService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<AccessoireDTO> getAllAccessoire(){
		return accessoireService.getAllAccessoire();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET) 
	public AccessoireDTO getAccessoireById(@PathVariable("id") Long id)
	{  
		return accessoireService.getAccessoire(id); 
	} 
	
	@RequestMapping(method = RequestMethod.POST) 
	public AccessoireDTO createAccessoire(@RequestBody AccessoireDTO accessoireDTO) 
	{ 
		return accessoireService.saveAccessoire(accessoireDTO); 
	} 
	
	@RequestMapping(method = RequestMethod.PUT) 
	public AccessoireDTO updateAccessoire(@RequestBody AccessoireDTO accessoireDTO) { 
	return accessoireService.updateAccessoire(accessoireDTO); 
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
