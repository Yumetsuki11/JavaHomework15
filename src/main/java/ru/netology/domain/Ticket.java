package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String departPort;
    protected String destPort;
    protected int travelTime;

    public Ticket() {
    }

    public Ticket(int id, int price, String departPort, String destPort, int travelTime) {
        this.id = id;
        this.price = price;
        this.departPort = departPort;
        this.destPort = destPort;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartPort() {
        return departPort;
    }

    public void setDepartPort(String departPort) {
        this.departPort = departPort;
    }

    public String getDestPort() {
        return destPort;
    }

    public void setDestPort(String destPort) {
        this.destPort = destPort;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price > o.price) {
            return 42;
        }
        if (this.price < o.price) {
            return -42;
        } else {
            return 0;
        }
    }
}
