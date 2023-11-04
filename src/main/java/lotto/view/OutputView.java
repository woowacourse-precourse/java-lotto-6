package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoResult;

public class OutputView {

    private static final String SEPARATOR = " - ";
    private static final String AMOUNT = "개";
    private static final String PURCHASE_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WINNING_STATISTICS_SEPARATOR = "---";
    private static final String REVENUE_MESSAGE = "총 수익률은 ";
    private static final String REVENUE_PERCENTAGE = "%입니다.";

    public void printPurchaseMessage() {
        System.out.println(PURCHASE_PROMPT_MESSAGE);
    }

    public void printBuyLotto(final int count) {
        System.out.println(count + LOTTO_PURCHASE_MESSAGE);
    }

    public void printLotto(final List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printResult(final LottoResult lottoResult, final double revenue) {
        printWinningStatisticsHeader();
        printRankCounts(lottoResult);
        printRevenue(revenue);
    }

    private void printWinningStatisticsHeader() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(WINNING_STATISTICS_SEPARATOR);
    }

    private void printRankCounts(final LottoResult lottoResult) {
        Map<String, Integer> rankCounts = lottoResult.getResult();
        rankCounts.forEach(this::printRankCount);
    }

    private void printRankCount(final String rank, final Integer count) {
        System.out.println(rank + SEPARATOR + count + AMOUNT);
    }

    private void printRevenue(final double revenue) {
        System.out.println(REVENUE_MESSAGE + revenue + REVENUE_PERCENTAGE);
    }
}
