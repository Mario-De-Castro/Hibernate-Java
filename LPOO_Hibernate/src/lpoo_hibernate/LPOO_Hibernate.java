package lpoo_hibernate;

import Manipulando.Autores;
import Manipulando.Emails;
import Manipulando.Livros;
import Manipulando.Editora;
import Manipulando.MetodosManipulacao;
import static Manipulando.MetodosManipulacao.EditoraByID;
import static Manipulando.MetodosManipulacao.AutorById;
import static Manipulando.MetodosManipulacao.EditoraVinteCinco;
import static Manipulando.MetodosManipulacao.EmailById;
import static Manipulando.MetodosManipulacao.LivroByID;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LPOO_Hibernate {
    
        public static void EmailAutor(EntityManager em){
        em.getTransaction().begin();
        
        Autores autor = new Autores();
        autor.name = "Mario de Castro";
        
        Emails email = new Emails();
        email.email = "mario.teste@teste.com.br";
        
        autor.emails.add(email);
        
        Autores autor1 = new Autores();
        autor1.name = "Universitario de Meia Idade";
        
        Emails email1 = new Emails();
        email1.email = "umi@teste.com.br";
        
        autor1.emails.add(email1);
        
        Autores autor2 = new Autores();
        autor2.name = "Ednaldo Pereira";
        
        Emails email2 = new Emails();
        email2.email = "edinaldo@teste.com.br";
        
        autor2.emails.add(email2);
        
        Autores autor3 = new Autores();
        autor3.name = "Pericleiton Rasta";
        
        Emails email3 = new Emails();
        email3.email = "galeradebocha@teste.com.br";
        
        autor3.emails.add(email3);
        
        Autores autor4 = new Autores();
        autor4.name = "Pericles Branco";
        
        Emails email4 = new Emails();
        email4.email = "whitePericles@teste.com.br";
        
        autor4.emails.add(email4);
        
        em.persist(autor);
        em.persist(autor1);
        em.persist(autor2);
        em.persist(autor3);
        em.persist(autor4);
        
        em.getTransaction().commit();
        }
        
        public static Livros LivroAutor(EntityManager em){
            em.getTransaction().begin();
            
            Livros livro = new Livros();
            livro.title = "Livro";
            livro.edicao = "EdicaoTeste";
            livro.custo = (float) 50.00;
            livro.autor = "Mario Teste";
            
            Livros livro1 = new Livros();
            livro1.title = "Livro Testando";
            livro1.edicao = "EdicaoTeste";
            livro1.custo = (float) 70.00;
            livro1.autor = "Mario Testado";
            
            Livros livro2 = new Livros();
            livro2.title = "Livro Alem do Teste";
            livro2.edicao = "EdicaoTeste";
            livro2.custo = (float) 90.00;
            livro2.autor = "Mario Alem do Teste";
            
            
            Livros livro3 = new Livros();
            livro3.title = "Livro Alem do Testado";
            livro3.edicao = "EdicaoTeste";
            livro3.custo = (float) 60.00;
            livro3.autor = "Mario Alem do Testado";
            
            Livros livro4 = new Livros();
            livro4.title = "Pequeno Sereia";
            livro4.edicao = "EdicaoTeste";
            livro4.custo = (float) 20.00;
            livro4.autor = "Ariel Sabao em Pó";
            
            em.persist(livro);
            em.persist(livro1);
            em.persist(livro2);
            em.persist(livro3);
            em.persist(livro4);
            
            em.getTransaction().commit();
            return livro;
        }
        
        public static void EditoraLivro(EntityManager em, Livros book){
            em.getTransaction().begin();
            
            Editora editora = new Editora();
            editora.codigo = 5;
            editora.name = "Editora Hibernate";
            editora.books.add(book);
            
            Editora editora1 = new Editora();
            editora1.codigo = 10;
            editora1.name = "Editora Perneta";
            editora1.books.add(book);
            
            Editora editora2 = new Editora();
            editora2.codigo = 15;
            editora2.name = "Editora UNIP";
            editora2.books.add(book);
            
            
            Editora editora3 = new Editora();
            editora3.codigo = 20;
            editora3.name = "Editora énocomplexo";
            editora3.books.add(book);
            
            Editora editora4 = new Editora();
            editora4.codigo = 25;
            editora4.name = "Editora Equatorial";
            editora4.books.add(book);
            
            em.persist(editora);
            em.persist(editora1);
            em.persist(editora2);
            em.persist(editora3);
            em.persist(editora4);
            
            em.getTransaction().commit();
        }        
        

    public static void main(String[] args) {
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPOO_HibernatePU");
            EntityManager em = emf.createEntityManager();
            EmailAutor(em);
            Livros book = LivroAutor(em);
            EditoraLivro(em, book);
            //Querys
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite aqui o ID desejado: ");
            int index = sc.nextInt();
            sc.close();
            List<Autores> resultado = AutorById(index,em);
            List<Emails> resultadoEmail = EmailById(index,em);
            List<Livros> resultado1 = LivroByID(index,em);
            List<Editora> resultado2 = EditoraByID(index,em);
            //Listagem das Querys
            for (int i = 0; i <= resultado.size()-1;i++){
                Autores a = (Autores) resultado.get(i);
                System.out.println("Dados do Autor:");
                System.out.println("Nome:"+ a.name);
                System.out.println("Livros:"+ a.book);
            }            
            for (int i = 0; i <= resultadoEmail.size()-1;i++){
                Emails e = (Emails) resultadoEmail.get(i);  
                System.out.println("Email:"+ e.email);
            }
            System.out.println();            
            for (int i = 0; i <= resultado1.size()-1;i++){
                Livros l = (Livros) resultado1.get(i);
                System.out.println("Dados do Livro:");
                System.out.println("Autor:"+ l.autor);
                System.out.println("Edição:"+ l.edicao);
                System.out.println("Titulo:"+ l.title);
                System.out.println("Custo:"+ l.custo);
            }
            System.out.println();
            for (int i = 0; i <= resultado2.size()-1;i++){
                Editora e = (Editora) resultado2.get(i);
                System.out.println("Dados da Editora: ");
                System.out.println("Nome: "+ e.name);
            }
            System.out.println();
            System.out.println("Listagem de Autores:");
            MetodosManipulacao.AllAutor(em);
            System.out.println();
            System.out.println("Editora de ID 25:");
            EditoraVinteCinco(em);
            
            em.close();
            emf.close();
        } catch(Exception e){
            System.out.println("Erro ao fazer o Select: " + e);
        }
            
    }
    
}
