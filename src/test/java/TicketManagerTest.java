import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.AviaSouls;
import ru.netology.javaqa.Ticket;
import ru.netology.javaqa.TicketTimeComparator;

import java.util.Comparator;

public class TicketManagerTest {

    @Test
    public void sortTicketsTest(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SIP", "KJA", 200, 10, 14);
        Ticket ticket2 = new Ticket("SIP", "KJA", 190, 11, 15);
        Ticket ticket3 = new Ticket("MSK", "KRR", 100, 10, 12);
        Ticket ticket4 = new Ticket("SIP", "KJA", 250, 7, 11);
        Ticket ticket5 = new Ticket("KJA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("SIP", "KJA", 230, 6, 10);
        Ticket ticket7 = new Ticket("SIP", "KJA", 300, 15, 20);
        Ticket ticket8 = new Ticket("SIP", "KJA", 500, 7, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};
        Ticket[] actual = manager.search("SIP", "KJA");
    }

    @Test
    public void oneTicketsTest(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SIP", "KJA", 200, 10, 14);
        Ticket ticket2 = new Ticket("SIP", "KJA", 190, 11, 15);
        Ticket ticket3 = new Ticket("MSK", "KRR", 100, 10, 12);
        Ticket ticket4 = new Ticket("SIP", "KJA", 250, 7, 11);
        Ticket ticket5 = new Ticket("KJA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("SIP", "KJA", 230, 6, 10);
        Ticket ticket7 = new Ticket("SIP", "KJA", 300, 15, 20);
        Ticket ticket8 = new Ticket("SIP", "KJA", 500, 7, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("MSK", "KRR");
    }

    @Test
    public void notTicketsTest(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SIP", "KJA", 200, 10, 14);
        Ticket ticket2 = new Ticket("SIP", "KJA", 190, 11, 15);
        Ticket ticket3 = new Ticket("MSK", "KRR", 100, 10, 12);
        Ticket ticket4 = new Ticket("SIP", "KJA", 250, 7, 11);
        Ticket ticket5 = new Ticket("KJA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("SIP", "KJA", 230, 6, 10);
        Ticket ticket7 = new Ticket("SIP", "KJA", 300, 15, 20);
        Ticket ticket8 = new Ticket("SIP", "KJA", 500, 7, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("OVB", "SPB");
    }

    @Test
    public void sortTicketWithComparator(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SIP", "KJA", 200, 10, 15); //5  5
        Ticket ticket2 = new Ticket("SIP", "KJA", 190, 11, 15); //4  2
        Ticket ticket3 = new Ticket("MSK", "KRR", 100, 10, 12);
        Ticket ticket4 = new Ticket("SIP", "KJA", 250, 7, 10);  //3  1
        Ticket ticket5 = new Ticket("KJA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("SIP", "KJA", 230, 6, 10);  //4  3
        Ticket ticket7 = new Ticket("SIP", "KJA", 300, 15, 20); //5  6
        Ticket ticket8 = new Ticket("SIP", "KJA", 500, 7, 11);  //4  4

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket2, ticket6, ticket8, ticket1, ticket7};
        Ticket[] actual = manager.search("SIP", "KJA", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTwoTicketWithComparator(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SIP", "KJA", 200, 10, 15);
        Ticket ticket2 = new Ticket("SIP", "KJA", 190, 11, 15);
        Ticket ticket3 = new Ticket("MSK", "KRR", 100, 10, 12);
        Ticket ticket4 = new Ticket("SIP", "KJA", 250, 7, 10);
        Ticket ticket5 = new Ticket("KJA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("SIP", "KJA", 230, 6, 10);
        Ticket ticket7 = new Ticket("SIP", "KJA", 300, 15, 20);
        Ticket ticket8 = new Ticket("MSK", "KRR", 500, 7, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket8};
        Ticket[] actual = manager.search("MSK", "KRR", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortNotTicketWithComparator(){
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SIP", "KJA", 200, 10, 15);
        Ticket ticket2 = new Ticket("SIP", "KJA", 190, 11, 15);
        Ticket ticket3 = new Ticket("MSK", "KRR", 100, 10, 12);
        Ticket ticket4 = new Ticket("SIP", "KJA", 250, 7, 10);
        Ticket ticket5 = new Ticket("KJA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("SIP", "KJA", 230, 6, 10);
        Ticket ticket7 = new Ticket("SIP", "KJA", 300, 15, 20);
        Ticket ticket8 = new Ticket("MSK", "KRR", 500, 7, 11);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("OVB", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
