package com.portfolio.smercado.Interface;

import com.portfolio.smercado.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
    //traer lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona;
    public void savePersona(Persona persona);
    
    //Eliminar un objeto por ID
    public void deletePersona(Long id);
    
    //Buscar Persona por ID
    public Persona findPersona(Long id);
            
}
