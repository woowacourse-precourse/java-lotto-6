package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.domain.Rank;

public class OutputView {
    public static void printLotteryNumber(List<Lotto> lottery) {
        String lottoNumberInfo = lottery
                .stream()
                .map(Lotto::lottoNumbers)
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
        System.out.println(lottoNumberInfo+"\n");
    }

    public static void printLotteryResult(Map<Rank, Integer> resultCount) {
        System.out.println(String.format("%s개 일치 (5,000원) - %s개", 3, resultCount.getOrDefault(Rank.FIFTH, 0)));
        System.out.println(String.format("%s개 일치 (50,000원) - %s개", 4, resultCount.getOrDefault(Rank.FOURTH, 0)));
        System.out.println(String.format("%s개 일치 (1,500,000원) - %s개", 5, resultCount.getOrDefault(Rank.THIRD, 0)));
        System.out.println(String.format("%s개 일치, 보너스 볼 일치 (30,000,000원) - %s개", 5, resultCount.getOrDefault(Rank.SECOND, 0)));
        System.out.println(String.format("%s개 일치 (2,000,000,000원) - %s개", 6, resultCount.getOrDefault(Rank.FIRST, 0)));
    }

    public static void printRateOfReturn(Long totalPrice, Price purchasePrice) {
        double result = (totalPrice * 100) / (purchasePrice.getPurchasePrice() * 1.0);
        System.out.println(String.format("총 수익률은 %,.1f%%입니다.", result));
    }

    public static void printPurchaseResult(Integer numOfLotto) {
        System.out.println(String.format("%s개를 구매했습니다.", numOfLotto));
    }

    public static void printCustomMessage(String message) {
        System.out.println(message);
    }
}
