package co.mintic.mh.moventHandler.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movimientos_dinero")
public class MovimientodeDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private long idTransaccion;
    @Column(name = "concepto_transaccion", nullable = false)
    private String conceptoTransaccion;
    @Column(name = "monto_transaccion", nullable = false)
    private float montoTransaccion;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(name = "fecha_creacion", nullable   = false)
    private LocalDate createdAt;
    @Column(name = "fecha_actualizacion")
    private LocalDate updatedAt;

    public MovimientodeDinero(long idTransaccion, String conceptoTransaccion, float montoTransaccion, Empleado empleado, Empresa empresa, LocalDate createdAt, LocalDate updatedAt) {
        this.idTransaccion = idTransaccion;
        this.conceptoTransaccion = conceptoTransaccion;
        this.montoTransaccion = montoTransaccion;
        this.empleado = empleado;
        this.empresa = empresa;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public MovimientodeDinero() {
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getConceptoTransaccion() {
        return conceptoTransaccion;
    }

    public void setConceptoTransaccion(String conceptoTransaccion) {
        this.conceptoTransaccion = conceptoTransaccion;
    }

    public float getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(float montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }



    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "MovimientodeDinero{" +
                "idTransaccion=" + idTransaccion +
                ", conceptoTransaccion='" + conceptoTransaccion + '\'' +
                ", montoTransaccion=" + montoTransaccion +
                ", empleado=" + empleado +
                ", empresa=" + empresa +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}