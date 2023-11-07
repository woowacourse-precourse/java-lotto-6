package lotto.Controller;

import lotto.Model.Enums.Prices;
import lotto.View.InputUI;
import lotto.View.OutputUI;

public class PurchaseController extends Controller{
    int purchasePrice;
    int ticketQuantity;
    @Override
    public void run(){
        OutputUI.printRequestPurchasePrice();
        purchasePrice = InputUI.inputPurchasePrice();   // inherent validating
        ticketQuantity = calculateTicketQuantity(purchasePrice);
        OutputUI.printSuccessfullyPurchased(ticketQuantity);
    }
    private int calculateTicketQuantity(int price){
        return price / Prices.ONE_LOTTO.intValue();
    }
}
