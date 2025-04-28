package com.jihed.accessoires.dto;

import java.util.Date;

import com.jihed.accessoires.entities.Marque;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessoireDTO {
	private Long idAccess;
	private String nomAccess;
	private String couleurAccess;
	private Double prixAccess;
	private Date dateSortieAcess;
	private Marque marque;
	private String nomMar;
}