package controller;

import static validator.MoneyValidator.moneyValidate;
import static view.inputView.moneyMessagePrint;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    public static int getMoneyInput() {
        moneyMessagePrint();
        while (true) {
            try {
                String money = Console.readLine();
                moneyValidate(money);
                int moneyNumber = Integer.parseInt(money);
                return moneyNumber;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
