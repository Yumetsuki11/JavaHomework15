package ru.netology.repository;

import ru.netology.domain.Ticket;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getDepartPort() == from & ticket.getDestPort() == to) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
