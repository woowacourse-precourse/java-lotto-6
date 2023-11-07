package lotto.interactor;

import lotto.interactor.validator.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Buyer {
    private int money;

    public int pay() {
        System.out.printf("구입금액을 입력해 주세요.");
        String moneyString = readLine();
        checkMoneyValid(moneyString);
        this.money = Integer.parseInt(moneyString);
        return this.money;
    }

    private void checkMoneyValid(String moneyString) {
        InputValidator.checkNumericFormat(moneyString);
        InputValidator.checkDivisibleByThousand(moneyString);
    }
}
