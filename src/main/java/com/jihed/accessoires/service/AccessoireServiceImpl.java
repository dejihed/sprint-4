package com.jihed.accessoires.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.entities.Marque;
import com.jihed.accessoires.repos.AccessoireRepository;
import com.jihed.accessoires.repos.MarqueRepository;

@Service
public class AccessoireServiceImpl implements AccessoireService{

	@Autowired
	AccessoireRepository accessoireRepository;
	
	@Autowired
	MarqueRepository marqueRepository;
	
	@Override
	public Accessoire saveAccessoire(Accessoire a) {
		return accessoireRepository.save(a);
	}

	@Override
	public Accessoire updateAccessoire(Accessoire a) {
		return accessoireRepository.save(a);
	}

	@Override
	public void deleteAccessoire(Accessoire a) {
		accessoireRepository.delete(a);
	}

	@Override
	public void deleteAccessoireById(Long id) {
		accessoireRepository.deleteById(id);
	}

	@Override
	public Accessoire getAccessoire(Long id) {
		return accessoireRepository.findById(id).get();
	}

	@Override
	public List<Accessoire> getAllAccessoire() {
		return accessoireRepository.findAll();
	}

	@Override
	public Page<Accessoire> getAllAccessoireParPage(int page, int size) {
		return accessoireRepository.findAll(PageRequest.of(page, size));  
	}

	@Override
	public List<Accessoire> findByNomAccess(String nom) {
		
		return accessoireRepository.findByNomAccess(nom);
	}

	@Override
	public List<Accessoire> findByNomAccessContains(String nom) {
		return accessoireRepository.findByNomAccessContains(nom);
	}

	@Override
	public List<Accessoire> findByNomPrix(String nom, Double prix) {
		return accessoireRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Accessoire> findByMarque(Marque marque) {
		return accessoireRepository.findByMarque(marque);
	}

	@Override
	public List<Accessoire> findByMarqueIdMar(Long id) {
		return accessoireRepository.findByMarqueIdMar(id);
	}

	@Override
	public List<Accessoire> findByOrderByNomAccessAsc() {
		return accessoireRepository.findByOrderByNomAccessAsc();
	}

	@Override
	public List<Accessoire> trierAccessoireNomsPrix() {
		return accessoireRepository.trierAccessoireNomsPrix();
	}
	
	@Override 
	 public List<Marque> getAllMarques() { 
	  return marqueRepository.findAll(); 
	 }

}
