package com.prueba.hulkstoreback.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hs_empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_empleado;
    private String iden_empleado;
    private String primer_nom_empleado;
    private String segundo_nom_empleado;
    private String primer_apell_empleado;
    private String segundo_apell_empleado;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date fecha_nac_empleado;
}
