package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class OutputView {
    private static final String PURCHASE_AMOUNT_OUTPUT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_OUTPUT_MESSAGE = "당첨통계";
    private static final String LINE_OUTPUT_MESSAGE = "---";
    private static final String SECOND_WINNING_RESULT_OUTPUT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String DEFAULT_WINNING_RESULT_OUTPUT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String TOTAL_RETURN_OUTPUT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void errorMessageOutput(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void purchaseAmountOuput(int lottoCount) {
        String purchaseAmount = String.format(PURCHASE_AMOUNT_OUTPUT_MESSAGE, lottoCount);
        System.out.println(purchaseAmount);
    }

    public void purchaseHistoryOutput(List<Lotto> purchaseHistory) {
        for (Lotto lotto : purchaseHistory) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void winningStatisticOutput(HashMap<LottoRank, Integer> lottoResult) {
        System.out.println(WINNING_STATISTICS_OUTPUT_MESSAGE);
        System.out.println(LINE_OUTPUT_MESSAGE);
        for (LottoRank lottoRank : lottoResult.keySet()) {
            showRankResult(lottoResult, lottoRank);
        }
    }

    private void showRankResult(HashMap<LottoRank, Integer> lottoResult, LottoRank lottoRank) {
        if (lottoRank.equals(LottoRank.NO_RNAK)) {
            return;
        }
        if (lottoRank.equals(LottoRank.SECOND)) {
            System.out.println(String.format(SECOND_WINNING_RESULT_OUTPUT_MESSAGE, lottoRank.getMatchCount(),
                    lottoRank.getOutputPrize(), lottoResult.get(lottoRank)));
            return;
        }
        System.out.println(String.format(DEFAULT_WINNING_RESULT_OUTPUT_MESSAGE, lottoRank.getMatchCount(),
                lottoRank.getOutputPrize(), lottoResult.get(lottoRank)));
    }

    public void totalReturnOutput(double totalReturn) {
        System.out.println(String.format(TOTAL_RETURN_OUTPUT_MESSAGE, totalReturn));
    }
}
