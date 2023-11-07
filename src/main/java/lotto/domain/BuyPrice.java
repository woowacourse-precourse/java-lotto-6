package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class BuyPrice {
    static public int buylotto() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                ErrorInput errorInput = new ErrorInput();
                errorInput.buy_range(input);
                errorInput.buy_price(Integer.parseInt(input));
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}