/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */

package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Operacao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirOperacao {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirOperacao() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TA-SegundaEtapa-ModelPU");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testePersistirOperacao() {
        boolean exception = false;
        try {
            Operacao obj = new Operacao();
            obj.setDataOperacao(Calendar.getInstance());
            obj.setJuroMensal(3.15);
            obj.setCliente(em.find(Cliente.class, 2));
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
