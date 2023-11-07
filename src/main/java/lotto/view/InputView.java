package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readMoney() {
        System.out.println(RequestMessage.MONEY.getMessage());
        String money = Console.readLine();
        return money.trim();
    }

    public String readSelectedNumbers() {
        System.out.println(RequestMessage.WINNING.getMessage());
        String numbers = Console.readLine();
        return numbers.trim();
    }

    public String readSelectedBonus() {
        System.out.println(RequestMessage.BONUS.getMessage());
        String bonus = Console.readLine();
        return bonus.trim();
    }
}
