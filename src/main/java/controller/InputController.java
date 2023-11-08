package controller;

import static view.inputView.moneyMessagePrint;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    public static void getMoneyInput() {
        moneyMessagePrint();
        String money = Console.readLine();
    }
}
