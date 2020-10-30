package Manipulando;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="EmailAutor")
@Table(name="Emails")
public class Emails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Email")
    public int id_email;

    @Column(length=100, nullable=false)
    public String email;
    
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="IDFK_Autor")
   public Autores Autores;
   


}


