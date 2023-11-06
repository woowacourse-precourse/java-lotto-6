package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Price;

public class User {
    public Price requestPurchasePrice() {
        while (true) {
            try {
                Price price = new Price(Console.readLine());
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
