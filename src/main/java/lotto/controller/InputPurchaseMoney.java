package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.controller.exception.RangeException;
import lotto.controller.exception.WrongTypeException;

public class InputPurchaseMoney {
    private static final String MESSAGE = "구입금액을 입력해 주세요.";

    public Integer getMoney() {
        System.out.println(MESSAGE);
        while (true) {
            String money = Console.readLine();
            System.out.println();
            try {
                validation(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validation(String money) {
        moneyValidation(money);
    }

    private void moneyValidation(String money) {
        if (!Pattern.compile("\\d+").matcher(money).matches()) {
            throw new WrongTypeException();
        }
        int purchaseMoney = Integer.parseInt(money);
        if (purchaseMoney == 0 || purchaseMoney % 1000 != 0) {
            throw new WrongTypeException();
        }
    }
}
