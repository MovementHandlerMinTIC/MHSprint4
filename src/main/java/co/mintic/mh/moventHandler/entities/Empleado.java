package co.mintic.mh.moventHandler.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Empleado", nullable = false)
    private long idEmpleado;
    @Column(name = "nombre_empleado", nullable = false)
    private String nombreEmpleado;
    @Column(name = "correo_empleado", nullable = false)
    private String correoEmpleado;
    @Column(name = "rol_empleado", nullable = false)
    private int rolEmpleado;
    @ManyToOne
    @JoinColumn(name = "id_Empresa")
    private  Empresa empresaEmpleado;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_actualizacion")
    private LocalDate updatedAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_creacion")
    private LocalDate createdAt;

    public Empleado(long idEmpleado, String nombreEmpleado, String correoEmpleado, int rolEmpleado, Empresa empresaEmpleado, LocalDate updatedAt, LocalDate createdAt) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public Empleado() {
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public int getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(int rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empresa getEmpresaEmpleado() {
        return empresaEmpleado;
    }

    public void setEmpresaEmpleado(Empresa empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}