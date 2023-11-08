package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.LottoException;
import lotto.validation.InputValidator;
import lotto.validation.MoneyInputValidator;

public class MoneyInputController {
    InputValidator inputValidator = new InputValidator();
    MoneyInputValidator moneyInputValidator = new MoneyInputValidator();

    public int inputMoney() {
        String money = "";
        while (true) {
            money = Console.readLine();
            try {
                checkMoneyNumber(money);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }
        }
        return Integer.parseInt(money);
    }

    public void checkMoneyNumber(String money) throws IllegalArgumentException {
        if (!inputValidator.isNumber(money)) {
            LottoException.notNumber();
        }
        checkMoneyThousand(money);
    }

    public void checkMoneyThousand(String money) throws IllegalArgumentException {
        int realMoney = Integer.parseInt(money);
        if (!moneyInputValidator.isDividedThousand(realMoney)) {
            LottoException.notThousand();
        }
    }
}
