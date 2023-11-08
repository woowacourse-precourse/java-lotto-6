package lotto.Model.Domain;

import lotto.Model.Enums.Prices;

import java.util.HashMap;
import java.util.List;

public class Customer {
    int purchasePrice;
    int ticketQuantity;
    List<Lotto> havingTickets;
    HashMap<String, Integer> resultPlaces;
    int prize;

    public int getTicketQuantity(){return ticketQuantity;}
    public List<Lotto> getHavingTickets(){return havingTickets;}
    public HashMap<String, Integer> getResultPlaces(){
        return resultPlaces;
    }
    public void setPurchasePrice(int price){this.purchasePrice = price;}
    public void setTicketQuantity(int quantity){this.ticketQuantity = quantity;}
    public void setHavingTickets(List<Lotto> tickets){this.havingTickets = tickets;}
    public void setResultPlaces(HashMap<String, Integer> resultPlaces){
        this.resultPlaces = resultPlaces;
    }
    public void setPrize(int prize){
        this.prize = prize;
    }
    public double calculateRateOfReturn(){
        double rawRate = (double) prize / (double) purchasePrice;
        return Math.floor((rawRate * 1000) + 0.5) / 1000;
    }
}
