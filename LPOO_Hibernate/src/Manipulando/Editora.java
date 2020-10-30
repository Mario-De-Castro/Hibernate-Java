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
@Table(name="Editora")
public class Editora {
    
    @Id
    public int codigo;
    
    @Column(name="Nome", length=100, nullable=false)
    public String name;

    @OneToMany(
    mappedBy="Editora",
    cascade = javax.persistence.CascadeType.ALL,
    orphanRemoval = true
    )
    public List<Livros> books = new ArrayList<>(); 
}