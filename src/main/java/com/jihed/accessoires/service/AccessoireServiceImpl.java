package com.jihed.accessoires.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jihed.accessoires.dto.AccessoireDTO;
import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.entities.Marque;
import com.jihed.accessoires.repos.AccessoireRepository;
import com.jihed.accessoires.repos.MarqueRepository;

@Service
public class AccessoireServiceImpl implements AccessoireService{

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AccessoireRepository accessoireRepository;
	
	@Autowired
	MarqueRepository marqueRepository;
	
	@Override
	public AccessoireDTO saveAccessoire(AccessoireDTO a) {
		return convertEntityToDto (accessoireRepository.save(convertDtoToEntity(a)));
	}

	@Override
	public AccessoireDTO updateAccessoire(AccessoireDTO a) {
		return convertEntityToDto(accessoireRepository.save(convertDtoToEntity(a)));
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
	public AccessoireDTO getAccessoire(Long id) {
		return convertEntityToDto (accessoireRepository.findById(id).get());
	}

	@Override
	public List<AccessoireDTO> getAllAccessoire() {
		return accessoireRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
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
	
	public AccessoireDTO convertEntityToDto(Accessoire accessoire) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AccessoireDTO accessoireDTO = modelMapper.map(accessoire, AccessoireDTO.class);
		
		return accessoireDTO;
		/*
		AccessoireDTO accessoireDTO = new AccessoireDTO();
		accessoireDTO.setIdAccess(a.getIdAccess());
		accessoireDTO.setNomAccess(a.getNomAccess());
		accessoireDTO.setCouleurAccess(a.getCouleurAccess());
		accessoireDTO.setPrixAccess(a.getPrixAccess());
		accessoireDTO.setMarque(a.getMarque());
		return accessoireDTO; 
		
		return AccessoireDTO.builder()
				.idAccess(a.getIdAccess())
				.nomAccess(a.getNomAccess())
				.couleurAccess(a.getCouleurAccess())
				.prixAccess(a.getPrixAccess())
				.dateSortieAcess(a.getDateSortieAcess())
				.marque(a.getMarque())
				.build();*/
				
	}

	@Override
	public Accessoire convertDtoToEntity(AccessoireDTO accessoireDto) {
		
		Accessoire accessoire = new Accessoire();
		accessoire = modelMapper.map(accessoireDto, Accessoire.class);
				return accessoire;
	}
/*
		Accessoire accessoire = new Accessoire();
		accessoire.setIdAccess(accessoireDto.getIdAccess());
		accessoire.setNomAccess(accessoireDto.getNomAccess());
		accessoire.setCouleurAccess(accessoireDto.getCouleurAccess());
		accessoire.setPrixAccess(accessoireDto.getPrixAccess());
		accessoire.setDateSortieAcess(accessoireDto.getDateSortieAcess());
		accessoire.setMarque(accessoireDto.getMarque());
		
		return null;
	}*/
		

}
