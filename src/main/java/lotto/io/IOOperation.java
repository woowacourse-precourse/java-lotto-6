package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Checker;

public class IOOperation {
    public static Integer getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer price;

        while (true) {
            try {
                price = Integer.parseInt(Console.readLine());
                Checker.priceCorrect(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }

        return price;
    }

}
