package view;

import java.util.List;
import lotto.Lotto;

public class Output {

    private static final String OUTPUT_LOTTO_QUANTITY = "개를 구매했습니다.";

    public static void printIssuedLotto(List<Lotto> lotteries) {
        System.out.println("\n" + lotteries.size() + OUTPUT_LOTTO_QUANTITY);
        lotteries.forEach(System.out::println);
    }
}
