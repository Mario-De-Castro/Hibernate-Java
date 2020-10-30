package Manipulando;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name="Autores")
public class Autores {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer codigo;
    
    @Column(name="Nome", length=80, nullable=false)
    public String name;
    
    @OneToMany(
    mappedBy = "Autores",
    cascade = javax.persistence.CascadeType.ALL,
    orphanRemoval = true
    )
    public List<Emails> emails = new ArrayList<>();
    
    @OneToMany(
    mappedBy="Autores",
    cascade = javax.persistence.CascadeType.ALL,
    orphanRemoval = true
    )
    public List<Livros> book = new ArrayList<>();
    
    
}
