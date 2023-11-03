package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInput {
    public static int deposit() {
        int amount = Integer.parseInt(Console.readLine());;
        try {
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("1000원 단위로 나누어지는 금액을 입금해주세요.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            deposit();
        }
        return amount;
    }
}
