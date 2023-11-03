package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class DepositInput {
    public static int deposit() {
        final int amount = Integer.parseInt(Console.readLine());;
        try {
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 나누어지는 금액을 입금해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return deposit();
        }
        return amount;
    }
}
