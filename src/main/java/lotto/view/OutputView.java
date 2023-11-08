package lotto.view;

import static lotto.constant.LottoGameMessage.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.constant.LottoGameMessage.NUMBER_OF_LOTTO_MESSAGE;
import static lotto.constant.LottoGameMessage.PAYMENT_AMOUNT_INPUT_MESSAGE;
import static lotto.constant.LottoGameMessage.RANKING_MESSAGE;
import static lotto.constant.LottoGameMessage.SECOND_RANKING_MESSAGE;
import static lotto.constant.LottoGameMessage.TOTAL_PROFIT_RATE_MESSAGE;
import static lotto.constant.LottoGameMessage.WINNING_DETAIL_MESSAGE;
import static lotto.constant.LottoGameMessage.WINNING_NUMBER_INPUT_MESSAGE;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {
    private static final String NUMBER_FORMAT = "###,###";

    public void requestPaymentAmount() {
        System.out.println(PAYMENT_AMOUNT_INPUT_MESSAGE.getMessage());
    }

    public void printLottoInfo(List<Lotto> lottos) {
        System.out.println(String.format(NUMBER_OF_LOTTO_MESSAGE.getMessage(), lottos.size()));
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public void requestWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void requestBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printWinningDetail(Map<Ranking, Integer> winningCount) {
        System.out.println(WINNING_DETAIL_MESSAGE.getMessage());

        List<Ranking> rankings = winningCount.keySet().stream().filter(ranking -> ranking != Ranking.NO_RANK).sorted()
                .collect(Collectors.toList());
        rankings.stream()
                .forEach(ranking -> System.out.println(makeRankingMessage(ranking, winningCount.get(ranking))));
    }

    private String makeRankingMessage(Ranking ranking, int lottoCount) {
        if (ranking == Ranking.SECOND_RANKING) {
            return String.format(SECOND_RANKING_MESSAGE.getMessage(), lottoCount);
        }
        return String.format(RANKING_MESSAGE.getMessage(), ranking.getAccordedCount(),
                commaFormatNumber(ranking.getWinningAmount()), lottoCount);
    }

    private String commaFormatNumber(int winningAmount) {
        DecimalFormat decimalFormat = new DecimalFormat(NUMBER_FORMAT);
        return decimalFormat.format(winningAmount);
    }

    public void printProfitRate(double profitRate) {
        System.out.println(String.format(TOTAL_PROFIT_RATE_MESSAGE.getMessage(), profitRate));
    }

    public void printLineOfSpace() {
        System.out.println();
    }
}
