package lotto.controller;

import lotto.core.policy.PickNumberPolicy;
import lotto.core.policy.PickUniqueNumberPolicy;
import lotto.core.policy.WinningCheckPolicy;
import lotto.core.policy.WinningPolicy;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(winningPolicy(), pickNumberPolicy());
        mainController.purchase();
    }

    private static WinningPolicy winningPolicy() {
        return new WinningCheckPolicy();
    }

    private static PickNumberPolicy pickNumberPolicy() {
        return new PickUniqueNumberPolicy();
    }
}
