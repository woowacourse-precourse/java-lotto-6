package lotto;

import static lotto.constant.GameMessage.*;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Price;

public class Game {

    public static void start() {
        Price price = inputBuyPrice();
        printBoughtAmount(price);
    }

    private static Price inputBuyPrice() {
        while (true) {
            System.out.println(INPUT_BUY_PRICE.getMessage());
            try {
                return new Price(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printBoughtAmount(Price price) {
        System.out.println(price.getAmount() + YOU_BOUGHT_N_LOTTOS.getMessage());
    }
}
