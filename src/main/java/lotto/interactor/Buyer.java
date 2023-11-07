package lotto.interactor;

import lotto.interactor.validator.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Buyer {
    private static int money;

    public int pay() {
        System.out.printf("구입금액을 입력해 주세요.");
        String moneyString = readLine();
        checkMoneyValid(moneyString);
        return Integer.parseInt(moneyString);
    }

    private void checkMoneyValid(String moneyString) {
        InputValidator.checkNumericFormat(moneyString);
        InputValidator.checkDivisibleByThousand(moneyString);
    }
}
