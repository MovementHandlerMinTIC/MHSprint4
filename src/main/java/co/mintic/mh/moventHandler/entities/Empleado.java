package co.mintic.mh.moventHandler.entities;

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
    private Enum_Roles rolEmpleado;
    @ManyToOne
    @JoinColumn(name = "id_Empresa")
    private  Empresa empresaEmpleado;
    @Column(name = "fecha_actualizacion")
    private LocalDate updatedAt;
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate createdAt;
    public Empleado(long idEmpleado, String correoEmpleado, Enum_Roles rolEmpleado, Empresa empresaEmpleado, LocalDate updatedAt, LocalDate createdAt, String nombreEmpleado) {
        this.idEmpleado = idEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.empresaEmpleado = empresaEmpleado;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.nombreEmpleado = nombreEmpleado;

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


    public Enum_Roles getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Enum_Roles rolEmpleado) {
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

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado=" + idEmpleado +
                ", correoEmpleado='" + correoEmpleado + '\'' +
                ", rolEmpleado=" + rolEmpleado +
                ", empresaEmpleado=" + empresaEmpleado +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", nombreEmpleado='" + nombreEmpleado + '\'' +
                '}';
    }
}