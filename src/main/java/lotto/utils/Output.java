package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Output {
    public static void printLottery(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(numbers);

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

    public static void printResult(Map<Prize, Integer> result, double winningStatistics) {
        System.out.println("당첨 통계\n" + "---");
        for (int i = Prize.values().length - 1; i >= 0; i--) {
            String description = Prize.values()[i].getDescription();
            Integer wins = result.get(Prize.values()[i]);

            System.out.println(description + wins + "개");
        }

        System.out.println("총 수익률은 " + String.format("%.1f", winningStatistics) + "%입니다.");
    }
}
