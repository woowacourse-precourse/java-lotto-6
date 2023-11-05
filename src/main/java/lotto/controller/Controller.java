package lotto.controller;

import lotto.domain.Buyer;
import lotto.view.InputView;

public class Controller {

    private Buyer buyer;

    public void run(){
        initBuyer();
    }

    private void initBuyer(){
        int amount = InputView.readAmount();
        buyer = new Buyer(amount);
    }
}
