package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.domain.Ticket;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 22222, "KVX", "VKO", 180);
    Ticket ticket2 = new Ticket(2, 20000, "KVX", "VKO", 190);
    Ticket ticket3 = new Ticket(3, 20400, "VKO", "KVX", 130);
    Ticket ticket4 = new Ticket(4, 29500, "GDX", "VKO", 540);
    Ticket ticket5 = new Ticket(5, 30100, "GDX", "VKO", 530);
    Ticket ticket6 = new Ticket(6, 13500, "KVX", "IWA", 110);

    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
    }

    @Test
    public void shouldSearchWhenNoMatches() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("LED", "PKV");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenOneElementMatches() {
        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("VKO", "KVX");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenTwoElementsMatchAndPriceDescending() {
        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = manager.search("KVX", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenTwoElementsMatchAndPriceAscending() {
        Ticket[] expected = {ticket4, ticket5};
        Ticket[] actual = manager.search("GDX", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenOnlyFromMatch() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("GDX", "XXX");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenOnlyToMatch() {
        Ticket[] expected = {};
        Ticket[] actual = manager.search("XXX", "IWA");

        Assertions.assertArrayEquals(expected, actual);
    }
}
