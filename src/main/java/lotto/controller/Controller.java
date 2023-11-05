package lotto.controller;

import lotto.data.PurchaseAmount;
import lotto.input.InputManager;
import lotto.output.ConsolePrinter;

public class Controller {

    PurchaseAmount purchaseAmount;

    public void inputPurchaseAmount(){

        ConsolePrinter.printPurchaseAmount();
        purchaseAmount =InputManager.inputPurchaseAmount();

    }
}
