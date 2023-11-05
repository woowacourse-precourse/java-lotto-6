package lotto.utils;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    public static void printLottery(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < numbers.size(); i++) {
            builder.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");

        System.out.println(builder.toString());
    }

    public static void printLotteries(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLottery(lotto);
        }
    }
}
