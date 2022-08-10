package ru.netology.repository;

import ru.netology.domain.AlreadyExistsException;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Ticket;

public class TicketRepository {
    Ticket[] Tickets = new Ticket[0];

    public void save(Ticket ticket) {
        for (Ticket oneTicket : Tickets) {
            if (ticket.getId() == oneTicket.getId()) {
                throw new AlreadyExistsException("Element with id: " + ticket.getId() + " already exists");
            }
        }
        Ticket[] tmp = new Ticket[Tickets.length + 1];
        for (int i = 0; i < Tickets.length; i++) {
            tmp[i] = Tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        Tickets = tmp;
    }

    public Ticket[] findAll() {
        return Tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : Tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        } else {
            Ticket[] tmp = new Ticket[Tickets.length - 1];
            int copyToIndex = 0;

            for (Ticket oneTicket : Tickets) {
                if (oneTicket.getId() != id) {
                    tmp[copyToIndex] = oneTicket;
                    copyToIndex++;
                }
            }

            Tickets = tmp;
        }
    }
}