package aplicacao;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Escreva os dados da pessoa: ");
		System.out.print("nome: ");
		String nome = sc.nextLine();
		System.out.print("email: ");
		String email = sc.next();
		Pessoa pessoa = new Pessoa(null, nome, email);

		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();

		System.out.println("Pronto!");
		em.close();
		emf.close();
	}
}
