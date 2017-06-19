/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */

package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cheque;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Estabelecimento;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirCliente {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirCliente() {

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
    public void testePersistirCliente() {
        boolean exception = false;
        try {
            Cliente obj = new Cliente();
            obj.setNome("Loja de Sapatos");
            obj.setTelefone("5433302028");
            obj.setCnpj("21808847000177");
            obj.setEstabelecimento(em.find(Estabelecimento.class, 1));
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
