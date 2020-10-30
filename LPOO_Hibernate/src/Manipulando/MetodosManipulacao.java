package Manipulando;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MetodosManipulacao {
    
    public static List<Autores> AutorById(int Codigo, EntityManager em){
        String select = "from Autores WHERE codigo = "+ Codigo;
        List<Autores> result = null;
        try{
            Query query = em.createQuery(select);
            result = query.getResultList();
        }catch(Exception e){
            System.out.println("Erro ao fazer a Query"+ e);
        }
        return result;
        }
    
        public static List<Emails> EmailById(int Codigo, EntityManager em){
        String selectEmail = "from EmailAutor WHERE ID_Email = "+ Codigo;
        List<Emails> resultEmail = null;
        try{
            Query queryEmail = em.createQuery(selectEmail);
            resultEmail = queryEmail.getResultList();
        }catch(Exception e){
            System.out.println("Erro ao fazer a Query"+ e);
        }
        return resultEmail;
        }

        public static List<Livros> LivroByID(int Codigo, EntityManager em){
        String select = "from Livros WHERE isbn = "+ Codigo;
        List<Livros> result = null;
        try{
            Query query = em.createQuery(select);
            result = query.getResultList();
        }catch(Exception e){
            System.out.println("Erro ao fazer a Query"+ e);
        }
        return result;
}
        
        public static List<Editora> EditoraByID(int Codigo, EntityManager em){
        ArrayList<Integer> code = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++){
            int num = 5 * i;
            code.add(num);
        }
        Codigo = code.get(Codigo - 1);
        String select = "from Editora WHERE codigo = "+ Codigo;
        List<Editora> result = null;
        try{
            Query query = em.createQuery(select);
            result = query.getResultList();
        }catch(Exception e){
            System.out.println("Erro ao fazer a Query"+ e);
        }
        return result;
}
        public static void AllAutor(EntityManager em){
        String select = "from Autores";
        List<Autores> resultado = null;
        try{
            Query query = em.createQuery(select);
            resultado = query.getResultList();
            for (int i = 0; i <= resultado.size()-1;i++){
                Autores aut = (Autores) resultado.get(i);
                System.out.println("ID: " + (i+1) + " Autor: "+ aut.name);
            }
        }catch(Exception e){
            System.out.println("Erro ao fazer a Query"+ e);
        }
        }
        
        public static void EditoraVinteCinco(EntityManager em){
        String select = "from Editora where codigo = 25";
        List<Editora> resultado = null;
        try{
            Query query = em.createQuery(select);
            resultado = query.getResultList();
            for (int i = 0; i <= resultado.size()-1;i++){
                Editora edit = (Editora) resultado.get(i);
                System.out.println("ID: " + "25" + " Editora: "+ edit.name);
            }
        }catch(Exception e){
            System.out.println("Erro ao fazer a Query"+ e);
        }
        }
    
        
}
