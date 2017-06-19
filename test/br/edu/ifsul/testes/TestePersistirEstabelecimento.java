/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */

package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Administrador;
import br.edu.ifsul.modelo.Estabelecimento;
import br.edu.ifsul.modelo.Operacao;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirEstabelecimento {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirEstabelecimento() {

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
    public void testePersistirEstabelecimento() {
        boolean exception = false;
        try {
            Estabelecimento obj = new Estabelecimento();
            obj.setNome("HSBC");
            obj.setCnpj("21808847000177");
            Administrador adm = em.find(Administrador.class, 1);
            obj.getAdministradores().add(adm);
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
