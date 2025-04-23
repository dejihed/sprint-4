package com.jihed.accessoires.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.entities.Marque;

public interface AccessoireService {

	Accessoire saveAccessoire(Accessoire a);

	Accessoire updateAccessoire(Accessoire p);

	void deleteAccessoire(Accessoire p);

	void deleteAccessoireById(Long id);

	Accessoire getAccessoire(Long id);

	List<Accessoire> getAllAccessoire();
	
	Page<Accessoire> getAllAccessoireParPage(int page,int size);
	List <Accessoire> findByNomAccess(String nom);
	List <Accessoire> findByNomAccessContains(String nom);
	List<Accessoire> findByNomPrix (@Param("nom")String nom,@Param("prix") Double prix);
	List<Accessoire> findByMarque (Marque marque);
	List<Accessoire> findByMarqueIdMar(Long id); 
	List<Accessoire> findByOrderByNomAccessAsc();
	List<Accessoire> trierAccessoireNomsPrix ();
	
	List<Marque> getAllMarques(); 
}
