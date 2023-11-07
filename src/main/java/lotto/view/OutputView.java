package lotto.view;

import lotto.model.*;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    public static void outputLottoTickets(int numberOfLottos,
                                          Lottos lottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");

        lottos.getLottos().forEach(lotto -> {
            List<Integer> numbers = lotto.getLottoNumbers();
            System.out.println(numbers);
        });
    }

    public static void outputResult(List<LottoResult> results,
                                    double profitRate) {
        printWinningStatistics(results);
        printReturnRate(profitRate);
    }

    public static void printWinningStatistics(List<LottoResult> results) {
        System.out.println("당첨 통계\n" + "---");

        Arrays.stream(LottoResult.values()).forEach(lottoResult -> {
                    long count = results.stream()
                            .filter(result -> result == lottoResult)
                            .count();

                    String matchBonus = getMatchBonusString(lottoResult);
                    System.out.println(lottoResult.getMatchCount() + "개 일치" + matchBonus + " (" + lottoResult.getPrizeMoney() + "원) - " + count + "개");
                });
    }

    private static void printReturnRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", profitRate) + "%입니다.");
    }

    private static String getMatchBonusString(LottoResult lottoResult) {
        if (lottoResult.isMatchBonus()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
