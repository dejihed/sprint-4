package com.jihed.accessoires.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
public class Accessoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccess;

    @NotNull
    @Size(min = 4, max = 15)
    private String nomAccess;

    private String couleurAccess;

    @Min(value = 10)
    @Max(value = 10000)
    private Double prixAccess;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateSortieAcess;

    @ManyToOne
    private Marque marque;
}
