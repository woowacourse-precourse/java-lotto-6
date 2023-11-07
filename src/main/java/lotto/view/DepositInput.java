package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Deposit;

public class DepositInput {

    public static Deposit deposit() {
        try {
            final int amount = Integer.parseInt(Console.readLine());;
            return new Deposit(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            System.out.println("다시 입력해주세요.");
            return deposit();
        }
    }
}
