package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    final static int LOTTO_PRICE = 1000;

    public void validateMoney(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원 보다 커야 합니다.");
        }
    }

    public int money() {
        System.out.println("구입 금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                validateMoney(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
