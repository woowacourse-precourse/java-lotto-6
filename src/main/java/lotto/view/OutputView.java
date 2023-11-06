package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.Quantity;

public class OutputView {
    private static final String MSG_RESULT = "당첨 통계";
    private static final String MSG_DIVISION = "---";
    private static final String MSG_PURCHASE = "%d개를 구매했습니다.";
    private static final String MSG_FIRST_PLACE = "6개 일치 (2,000,000,000원)";
    private static final String MSG_SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String MSG_THIRD_PLACE = "5개 일치 (1,500,000원)";
    private static final String MSG_FOURTH_PLACE = "4개 일치 (50,000원)";
    private static final String MSG_FIFTH_PLACE = "3개 일치 (5,000원)";
    private static final String MSG_PROFIT = "총 수익률은 %.1f%%입니다.";

    private static final String COUNT_NOUN = "개";
    private static final String NEW_LINE = "\n";
    private static final String DASH = " - ";


    public void printQuantityOfLotteries(Quantity quantity) {
        System.out.printf(MSG_PURCHASE + NEW_LINE, quantity.getQuantity());
    }

    public void printBoughtLottos(Lottos lottos) {
        String boughtLottos = lottos.getLottos().stream()
                .map(lotto -> lotto.getNumbers() + "")
                .collect(Collectors.joining(NEW_LINE));
        System.out.println(boughtLottos);
    }

    public void printResult(LottoResult result) {
        System.out.println(MSG_RESULT);
        System.out.println(MSG_DIVISION);

        printPrizeFormat(Prize.FIRST, MSG_FIRST_PLACE, result);
        printPrizeFormat(Prize.SECOND, MSG_SECOND_PLACE, result);
        printPrizeFormat(Prize.THIRD, MSG_THIRD_PLACE, result);
        printPrizeFormat(Prize.FOURTH, MSG_FOURTH_PLACE, result);
        printPrizeFormat(Prize.FIFTH, MSG_FIFTH_PLACE, result);
    }

    private void printPrizeFormat(Prize prize, String message, LottoResult result) {
        long prizeCount = result.getResult().getOrDefault(prize, 0L);
        System.out.printf(message + DASH + "%d" + COUNT_NOUN + NEW_LINE, prizeCount);
    }

    public void printProfit(double roundedProfit) {
        System.out.printf(MSG_PROFIT + NEW_LINE, roundedProfit);
    }
}
