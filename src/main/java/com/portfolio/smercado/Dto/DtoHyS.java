package com.portfolio.smercado.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author santi
 */

public class DtoHyS {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public DtoHyS() {
    }

    public DtoHyS(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
