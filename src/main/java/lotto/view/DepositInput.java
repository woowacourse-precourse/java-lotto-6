package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Deposit;

public class DepositInput {

    private static final String ERROR_ALARM = "[ERROR] ";

    public static Deposit deposit() {
        try {
            String deposit = Console.readLine();
            int amount = WinningNumbersInput.getNumber(deposit);
            return new Deposit(amount);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_ALARM + e.getMessage());
            return deposit();
        }
    }
}
