package lotto.controller;

import static lotto.view.InputView.readLine;

import lotto.domain.Buyer;
import lotto.view.InputView;

public class MainController {
    private static final BuyerController buyerController = new BuyerController();

    public MainController() {
    }

    public static void run() {
        Buyer buyer = buyerController.getBuyerInfo();
    }
}
