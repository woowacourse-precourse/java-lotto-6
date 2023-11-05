package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BuyPrice;

public class Application {
    public static void main(String[] args) {
        BuyPrice buyPrice = new BuyPrice();
        String input = Console.readLine();
        int price = Integer.parseInt(input);
        price = BuyPrice.buylotto(price);
        System.out.println(price);
    }
}
