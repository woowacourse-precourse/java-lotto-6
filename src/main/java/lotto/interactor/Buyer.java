package lotto.interactor;

import lotto.interactor.validator.InputValidator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Buyer {
    private int money;

    public int pay() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyString = readLine();
        checkMoneyValid(moneyString);
        return Integer.parseInt(moneyString);
    }

    private void checkMoneyValid(String moneyString) {
        InputValidator.checkNumericFormat(moneyString);
        InputValidator.checkDivisibleByThousand(moneyString);
    }

    public int getTickets() {
        int ticketNums = this.money/1000;
        System.out.println();
        System.out.println(ticketNums + "개를 구매했습니다.");
        return ticketNums;
    }
}
