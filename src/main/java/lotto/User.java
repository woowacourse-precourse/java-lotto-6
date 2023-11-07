package lotto;

import camp.nextstep.edu.missionutils.Console;
import util.Validate;

import java.util.List;

public class User {
    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());

        try {
            Validate.isValidPrice(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPrice();
        }

        return price;
    }
}
