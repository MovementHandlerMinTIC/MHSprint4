package co.mintic.mh.moventHandler.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Empleados")
@Data @NoArgsConstructor
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

    public Empleado(long idEmpleado, String nombreEmpleado, String correoEmpleado, Enum_Roles rolEmpleado, Empresa empresaEmpleado, LocalDate updatedAt, LocalDate createdAt) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }


}