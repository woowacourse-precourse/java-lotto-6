package lotto.Model.Domain;

import java.util.List;

public class Customer {
    int purchasePrice;
    int ticketQuantity;
    List<Lotto> havingTickets;

    public int getTicketQuantity(){return ticketQuantity;}
    public void setPurchasePrice(int price){this.purchasePrice = price;}
    public void setTicketQuantity(int quantity){this.ticketQuantity = quantity;}
    public void setHavingTickets(List<Lotto> tickets){this.havingTickets = tickets;}
}
