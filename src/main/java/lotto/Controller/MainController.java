package lotto.Controller;

import lotto.Model.Domain.Customer;
import lotto.Model.Domain.Lotto;
import java.util.List;

public class MainController extends Controller{
    PurchaseController purchaseController;
    DrawTicketController drawTicketController;
    Customer client;
    public MainController(){
        purchaseController = new PurchaseController();
        client = new Customer();
    }
    @Override
    public void run(){
        purchaseController.run();
        updateClient(purchaseController.purchasePrice, purchaseController.ticketQuantity);
        drawTicketController = new DrawTicketController(client.getTicketQuantity());
        drawTicketController.run();
        updateClient(drawTicketController.lotteryTickets);
    }
    public void updateClient(int price, int quantity){
        client.setPurchasePrice(price);
        client.setTicketQuantity(quantity);
    }
    public void updateClient(List<Lotto> lottos){
        client.setHavingTickets(lottos);
    }
}
