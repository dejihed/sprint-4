package com.jihed.accessoires.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.jihed.accessoires.dto.AccessoireDTO;
import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.entities.Marque;

public interface AccessoireService {

	AccessoireDTO saveAccessoire(AccessoireDTO a);
	AccessoireDTO getAccessoire(Long id);
	List<AccessoireDTO> getAllAccessoire();
	
	

	AccessoireDTO updateAccessoire(AccessoireDTO p);

	void deleteAccessoire(Accessoire p);

	void deleteAccessoireById(Long id);

	
	
	Page<Accessoire> getAllAccessoireParPage(int page,int size);
	List <Accessoire> findByNomAccess(String nom);
	List <Accessoire> findByNomAccessContains(String nom);
	List<Accessoire> findByNomPrix (@Param("nom")String nom,@Param("prix") Double prix);
	List<Accessoire> findByMarque (Marque marque);
	List<Accessoire> findByMarqueIdMar(Long id); 
	List<Accessoire> findByOrderByNomAccessAsc();
	List<Accessoire> trierAccessoireNomsPrix ();
	
	List<Marque> getAllMarques(); 
	
	Accessoire convertDtoToEntity(AccessoireDTO accessoireDto);
	AccessoireDTO convertEntityToDto(Accessoire a);
}
