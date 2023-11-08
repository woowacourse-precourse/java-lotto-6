package lotto.view;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.constant.PriceConstant;
import lotto.domain.Lotteries;

public class OutputView {

    private static final String PRINT_PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String PRINT_WINNING_STATS_MESSAGE = "당첨 통계\n---";
    private static final String PRINT_WINNING_STATS_RESULT_MESSAGE = "%d개 일치 (%,d원) - %d개\n";
    private static final String PRINT_WINNING_STATS_BONUS_RESULT_MESSAGE = "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String PRINT_TOTAL_EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String PRINT_NEW_LINE = "\n";

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.printf(PRINT_PURCHASE_RESULT_MESSAGE, purchaseAmount);
    }

    public void printLottoNumbers(Lotteries lotteries) {
        String lotteriesNumbers = lotteries.getLotteries().stream()
                .map(lotto -> String.valueOf(lotto.getNumbers()))
                .collect(Collectors.joining(PRINT_NEW_LINE));
        System.out.println(lotteriesNumbers);
    }

    public void printGameResult(Map<String, Integer> lottoResult) {
        System.out.println(PRINT_WINNING_STATS_MESSAGE);

        for (Map.Entry<String, Integer> result : lottoResult.entrySet()) {
            if (result.getKey().equals(PriceConstant.SECOND_PLACE.getLabel())) {
                System.out.printf(PRINT_WINNING_STATS_BONUS_RESULT_MESSAGE,
                        PriceConstant.getPriceByLabel(result.getKey()), result.getValue());
                continue;
            }

            System.out.printf(PRINT_WINNING_STATS_RESULT_MESSAGE, PriceConstant.getCountByLabel(result.getKey()),
                    PriceConstant.getPriceByLabel(result.getKey()), result.getValue());
        }
    }

    public void printEarningRate(double printEarningRate) {
        System.out.printf(PRINT_TOTAL_EARNING_RATE_MESSAGE, printEarningRate);
    }
}
