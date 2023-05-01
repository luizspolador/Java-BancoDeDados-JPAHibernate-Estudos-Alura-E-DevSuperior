package br.com.aplicacao;

import br.com.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
        // criando objetos do tipo Pessoa
        // id = null pq o próprio db fornecerá um id automaticamente
//        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//        Pessoa p2 = new Pessoa(null, "Luiz Spolador", "luiz@gmail.com");
//        Pessoa p3 = new Pessoa(null, "Sarah Moretto", "sarah@gmail.com");

        //instanciando EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

        //instanciando EntityManager
        EntityManager em = emf.createEntityManager();

        //busca o objeto pelo ID
//        Pessoa p = em.find(Pessoa.class, 2);
//        System.out.println(p);

        //usado somente para deletar do db
        em.getTransaction().begin();

        //deletando do db
        Pessoa pessoaRemovida = em.find(Pessoa.class, 1);
        em.remove(pessoaRemovida);
        em.getTransaction().commit();
        // sempre necessário iniciar uma transação com db
//        em.getTransaction().begin();
//
//        // persist pega um objeto e salva no db
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//
//        //confirma as alterações realizadas
//        em.getTransaction().commit();
        System.out.println("Pronto");
        em.close();
        emf.close();
    }
}
