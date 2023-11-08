package lotto.interactor;

import lotto.interactor.validator.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Buyer {
    private final int money;

    public Buyer() {
        this.money = pay();
    }

    public int pay() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String moneyString = readLine();
            checkMoneyValid(moneyString);
            return Integer.parseInt(moneyString);
        } catch (IllegalArgumentException e) {
            return pay();
        }
    }

    private void checkMoneyValid(String moneyString) {
        InputValidator.checkNumericFormat(moneyString);
        InputValidator.checkDivisibleByThousand(moneyString);
    }

    public int getTickets() {
        return this.money/1000;
    }
}
