package co.mintic.mh.moventHandler.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Empleados")
@Data @NoArgsConstructor @AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Empleado", nullable = false)
    private long idEmpleado;
    @Column(name = "nombre_empleado", nullable = false)
    private String nombreEmpleado;
    @Column(name = "correo_empleado", nullable = false)
    private String correoEmpleado;
    @Column(name = "rol_empleado")
    private Enum_Roles rolEmpleado;
    @ManyToOne
    @JoinColumn(name = "id_Empresa")
    private  Empresa empresaEmpleado;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_actualizacion")
    private LocalDate updatedAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_creacion")
    private LocalDate createdAt;




}