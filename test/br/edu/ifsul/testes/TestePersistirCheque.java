/*
 * @Author: Julio Sergio Quadros dos Santos.
 * @Email: julioquadros@hotmail.com
 * @2017 - Todos os Direitos Reservados
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cheque;
import br.edu.ifsul.modelo.Operacao;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirCheque {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirCheque() {

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
    public void testePersistirCheque() {
        boolean exception = false;
        try {

            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 30);  // number of days to add

            Cheque obj = new Cheque();
            obj.setAgencia("0170");
            obj.setBanco("041");
            obj.setDataDeposito(Calendar.getInstance());
            obj.setNumCheque("001");
            obj.setNumConta("3500201");
            obj.setValor(300.00);
            obj.setEmitenteCpfCnpj("81954379072");
            obj.setOperacao(em.find(Operacao.class, 1));
            Cheque obj2 = new Cheque();
            obj2.setAgencia("0170");
            obj2.setBanco("041");
            obj2.setDataDeposito(c);
            obj2.setNumCheque("002");
            obj2.setNumConta("3500201");
            obj2.setValor(300.00);
            obj2.setEmitenteCpfCnpj("81954379072");
            obj2.setOperacao(em.find(Operacao.class, 1));
            em.getTransaction().begin();
            em.persist(obj);
            em.persist(obj2);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;

        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
