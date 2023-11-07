package lotto.Controller;

import lotto.Model.Domain.Customer;
import lotto.Model.Domain.Lotto;
import lotto.View.OutputUI;

import java.util.List;

public class MainController extends Controller {
    PurchaseController purchaseController;
    DrawTicketController drawTicketController;
    WinningNumberController winningNumberController;
    Customer client;

    public MainController() {
        purchaseController = new PurchaseController();
        winningNumberController = new WinningNumberController();
        client = new Customer();
    }

    @Override
    public void run() {
        purchaseController.run();
        updateClient(purchaseController.purchasePrice, purchaseController.ticketQuantity);
        drawTicketController = new DrawTicketController(client.getTicketQuantity());
        drawTicketController.run();
        updateClient(drawTicketController.lotteryTickets);
        lottosOfClient(client);
        winningNumberController.run();
    }

    private void updateClient(int price, int quantity) {
        client.setPurchasePrice(price);
        client.setTicketQuantity(quantity);
    }

    private void updateClient(List<Lotto> lottos) {
        client.setHavingTickets(lottos);
    }

    private void lottosOfClient(Customer client) {
        OutputUI.printLottos(client.getHavingTickets());
    }
}
