package lotto.Controller;

import lotto.Model.Domain.Customer;
import lotto.Model.Domain.Lotto;
import lotto.Model.Domain.WinningData;
import lotto.View.OutputUI;

import java.util.HashMap;
import java.util.List;

public class MainController extends Controller {
    PurchaseController purchaseController;
    DrawTicketController drawTicketController;
    WinningNumberController winningNumberController;
    ResultController resultController;
    Customer client;
    WinningData winningData;

    public MainController() {
        purchaseController = new PurchaseController();
        winningNumberController = new WinningNumberController();
        client = new Customer();
        winningData = new WinningData();
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
        updateWinningData(winningNumberController.winningNumber, winningNumberController.bonusNumber);

        resultController = new ResultController(client.getHavingTickets(),
                winningData.getWinningNumber(), winningData.getWinningBonusNumber());
        resultController.run();
        updateClient(resultController.resultPlaces);
        updateClient(resultController.prize);

        OutputUI.printResultStatistic(client);
    }

    private void updateClient(int price, int quantity) {
        client.setPurchasePrice(price);
        client.setTicketQuantity(quantity);
    }
    private void updateClient(List<Lotto> lottos) {
        client.setHavingTickets(lottos);
    }
    private void updateClient(HashMap<String, Integer> resultPlaces){
        client.setResultPlaces(resultPlaces);
    }
    private void updateClient(int prize){
        client.setPrize(prize);
    }
    private void lottosOfClient(Customer client) {
        OutputUI.printLottos(client.getHavingTickets());
    }
    private void updateWinningData(List<Integer> winningNumber, int winningBonusNumber){
        winningData.setWinningNumber(winningNumber);
        winningData.setWinningBonusNumber(winningBonusNumber);
    }
}
