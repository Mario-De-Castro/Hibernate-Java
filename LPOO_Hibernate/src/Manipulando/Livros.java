package Manipulando;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Livros")
public class Livros {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int isbn;
    
    @Column(name="Edicao", length=100, nullable=false)
    public String edicao;
    
    @Column(name="Custo", length=80, nullable=false)
    public float custo;
    
    @Column(name="Titulo", length=100, nullable=false)
    public String title;
    
    @Column(name="Autor", length=100, nullable=false)
    public String autor;
    
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="IDFK_Livros")
   Autores Autores;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="IDFK_Editora")
   Editora Editora;
    
}
