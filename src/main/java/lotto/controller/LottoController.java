package lotto.controller;

import lotto.domain.Money;

public class LottoController {

    private final UserController userController = new UserController();

    public void start() {
        int money = userController.requestMoney();

    }
}