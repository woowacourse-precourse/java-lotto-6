package lotto;

import static lotto.constant.GameMessage.INPUT_BUY_PRICE;
import static lotto.constant.GameMessage.YOU_BOUGHT_N_LOTTOS;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Price;

public class Game {

    public static void start() {
        Price price = inputBuyPrice();
        printBoughtAmount(price);
        List<Lotto> lottos = makeLottos(price.getAmount() / 1000);
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

    private static List<Lotto> makeLottos(long amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }
}
