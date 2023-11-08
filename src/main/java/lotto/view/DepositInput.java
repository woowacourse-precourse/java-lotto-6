package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Constant;
import lotto.domain.Deposit;

public class DepositInput {

    public static Deposit deposit() {
        try {
            String deposit = Console.readLine();
            int amount = WinningNumbersInput.getNumber(deposit);
            return new Deposit(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.ERROR_ALARM + e.getMessage());
            return deposit();
        }
    }
}
