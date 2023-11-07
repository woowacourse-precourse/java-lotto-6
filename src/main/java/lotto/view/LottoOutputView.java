package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.Message;
import lotto.constant.Winning;

public class LottoOutputView {

    public void printLottoPurchaseCount(int count) {
        System.out.println(count + Message.PURCHASE_COUNT.getMessage());
    }

    public void printLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

    public void printWinningStatistics(Map<Winning, Integer> prize) {
        LottoOutputView.lineBreak();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prize.get(Winning.FIFTH) + "개");
        System.out.println("4개 일치 (50,000원) - " + prize.get(Winning.FOURTH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prize.get(Winning.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prize.get(Winning.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prize.get(Winning.FIRST) + "개");
    }

    public void printRateOfReturn(double rate) {
        rate = (double) Math.round(rate * 100) / 100;
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public static void lineBreak() {
        System.out.print("\n");
    }
}
