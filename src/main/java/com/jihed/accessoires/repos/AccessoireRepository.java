package com.jihed.accessoires.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.entities.Marque;

@RepositoryRestResource(path = "rest")
@CrossOrigin(origins = "*")
public interface AccessoireRepository extends JpaRepository<Accessoire, Long> {

	List <Accessoire> findByNomAccess(String nom);
	List <Accessoire> findByNomAccessContains(String nom);
	
	@Query("select a from Accessoire a where a.nomAccess like %:nom and a.prixAccess > :prix") 
	List<Accessoire> findByNomPrix (@Param("nom")String nom,@Param("prix") Double prix); 
	
	
	@Query("select a from Accessoire a where a.marque = ?1") 
	List<Accessoire> findByMarque (Marque marque); 
	
	List<Accessoire> findByMarqueIdMar(Long id); 
	
	List<Accessoire> findByOrderByNomAccessAsc();
	
	@Query("select a from Accessoire a order by a.nomAccess ASC, a.prixAccess DESC") 
	List<Accessoire> trierAccessoireNomsPrix ();

}
