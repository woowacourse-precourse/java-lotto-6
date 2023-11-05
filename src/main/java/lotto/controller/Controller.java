package lotto.controller;

import lotto.domain.Buyer;
import lotto.view.InputView;

public class Controller {

    private Buyer buyer;

    public void run(){
        initBuyer();
        printBuyersLotto();
    }

    private void initBuyer(){
        int amount = InputView.readAmount();
        buyer = new Buyer(amount);
    }

    private void printBuyersLotto(){
        buyer.printLotto();
    }
}
