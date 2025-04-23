package com.jihed.accessoires.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.entities.Marque;
import com.jihed.accessoires.service.AccessoireService;

import jakarta.validation.Valid;

@Controller
public class AccessoireController {

    @Autowired
    AccessoireService accessoireService;
    
    @GetMapping(value = "/") 
    public String welcome() { 
    return "index"; 
    } 

    @RequestMapping("/listeAccessoire")
    public String listeAccessoires(ModelMap modelMap,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "3") int size) {

        Page<Accessoire> access = accessoireService.getAllAccessoireParPage(page, size);
        modelMap.addAttribute("accessoires", access);
        modelMap.addAttribute("pages", new int[access.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "liste";
    }

    @RequestMapping("/showCreate") 
    public String showCreate(ModelMap modelMap) 
    { 
    List<Marque> mar = accessoireService.getAllMarques(); 
    modelMap.addAttribute("accessoire", new Accessoire()); 
    modelMap.addAttribute("mode","new");
    modelMap.addAttribute("marques", mar); 
    return "formAccessoire"; 
    } 


    @RequestMapping("/saveAccessoire") 
    public String saveAccessoire(@Valid Accessoire accessoire, BindingResult bindingResult,
    		@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) 
    { 
    	int currentPage;
    	boolean isNew = false;
     if (bindingResult.hasErrors()) return "formAccessoire";  
     
     if (accessoire.getIdAccess()==null)
    	 isNew=true;
     
      
     accessoireService.saveAccessoire(accessoire);  
     
     if (isNew)  
     { 
     Page<Accessoire> access = accessoireService.getAllAccessoireParPage(page, size); 
     currentPage = access.getTotalPages()-1; 
     } 
     else //modif 
     currentPage=page; 
     
     return ("redirect:/listeAccessoire?page="+currentPage+"&size="+size);  
    }



    @RequestMapping("/supprimerAccessoire")
    public String supprimerAccessoire(@RequestParam("id") Long id,
                                      ModelMap modelMap,
                                      @RequestParam(name = "page", defaultValue = "0") int page,
                                      @RequestParam(name = "size", defaultValue = "3") int size) {

        accessoireService.deleteAccessoireById(id);

        Page<Accessoire> access = accessoireService.getAllAccessoireParPage(page, size);
        modelMap.addAttribute("accessoires", access);
        modelMap.addAttribute("pages", new int[access.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "liste";
    }

    @RequestMapping("/modifierAccessoire")
    public String modifierAccessoire(@RequestParam("id") Long id, ModelMap modelMap,
    		@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "3") int size) {
        // Retrieve the Accessoire using the provided ID
        Accessoire accessoire = accessoireService.getAccessoire(id);
        
        // Retrieve all available Marque objects
        List<Marque> mar = accessoireService.getAllMarques(); 
        
        // Add the accessoire and marques to the model for use in the view
        modelMap.addAttribute("accessoire", accessoire);
        modelMap.addAttribute("marques", mar);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);

        return "formAccessoire"; // Return the view name
    }

    

    @RequestMapping("/updateAccessoire")
    public String updateAccessoire(@ModelAttribute("accessoire") Accessoire accessoire,
                                   @RequestParam("date") String date,
                                   ModelMap modelMap) throws ParseException {

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateSortie = dateformat.parse(date);
        accessoire.setDateSortieAcess(dateSortie);

        accessoireService.updateAccessoire(accessoire);

        List<Accessoire> access = accessoireService.getAllAccessoire();
        modelMap.addAttribute("accessoires", access);

        return "liste";
    }}