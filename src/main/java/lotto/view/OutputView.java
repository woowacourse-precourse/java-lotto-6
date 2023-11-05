package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {
    public static void printLotteryNumber(List<Lotto> lottery) {
        String lottoNumberInfo = lottery
                .stream()
                .map(Lotto::getNumbers)
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
        System.out.println(lottoNumberInfo);
    }

    public static void printLotteryResult(Map<Integer, Integer> resultCount, String purchasePrice) {
        System.out.println(String.format("%s개 일치 (5,000원) - %s개", 3, resultCount.getOrDefault(5, 0)));
        System.out.println(String.format("%s개 일치 (50,000원) - %s개", 4, resultCount.getOrDefault(4, 0)));
        System.out.println(String.format("%s개 일치 (1,500,000원) - %s개", 5, resultCount.getOrDefault(3, 0)));
        System.out.println(String.format("%s개 일치, 보너스 볼 일치 (30,000,000원) - %s개", 5, resultCount.getOrDefault(2, 0)));
        System.out.println(String.format("%s개 일치 (2,000,000,000원) - %s개", 6, resultCount.getOrDefault(1, 0)));

        Long totalPrice = Long.valueOf(
                5000 * resultCount.getOrDefault(5, 0) + 50000 * resultCount.getOrDefault(4, 0) + 1_500_000 * resultCount.getOrDefault(3, 0)
                        + 30_000_000 * resultCount.getOrDefault(2, 0) + 2_000_000_000 * resultCount.getOrDefault(1, 0));
        double result = (totalPrice * 100) / (Integer.valueOf(purchasePrice) * 1.0);
        System.out.println(String.format("%,.1f%%", result));
    }
}
