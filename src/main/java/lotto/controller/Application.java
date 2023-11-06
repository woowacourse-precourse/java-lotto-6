package lotto.controller;

import lotto.controller.MainController;
import lotto.core.policy.WinningCheckPolicy;
import lotto.core.policy.WinningPolicy;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(winningPolicy());
        mainController.purchase();
    }

    private static WinningPolicy winningPolicy(){
        return new WinningCheckPolicy();
    }
}
