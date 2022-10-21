package com.portfolio.smercado.Security.Dto;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author santi
 */
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> Authorities;

    
    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> Authorities) {
        this.token = token;
        this.nombreUsuario = nombreUsuario;
        this.Authorities = Authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> Authorities) {
        this.Authorities = Authorities;
    }
    
    
}
