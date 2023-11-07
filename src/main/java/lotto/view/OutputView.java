package lotto.view;

import static lotto.view.constant.OutputMessage.NEWLINE;
import static lotto.view.constant.OutputMessage.PURCHASED_COUNT;
import static lotto.view.constant.OutputMessage.STATS_MESSAGE;
import static lotto.view.constant.OutputMessage.WINNING_STATS_FIRST_RANK;
import static lotto.view.constant.OutputMessage.WINNING_STATS_FIVE_RANK;
import static lotto.view.constant.OutputMessage.WINNING_STATS_FOUR_RANK;
import static lotto.view.constant.OutputMessage.WINNING_STATS_PROFIT_RATE;
import static lotto.view.constant.OutputMessage.WINNING_STATS_SECOND_RANK;
import static lotto.view.constant.OutputMessage.WINNING_STATS_THIRD_RANK;

import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.LottoProfit;
import lotto.domain.Lottos;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoNumbers(Lottos lottos) {
        StringBuilder lottoNumberResult = new StringBuilder();
        lottoNumberResult.append(NEWLINE.getMessage())
                .append(lottos.getLottos().size())
                .append(PURCHASED_COUNT.getMessage())
                .append(NEWLINE.getMessage());
        lottos.getLottos()
                .forEach(lotto -> createLottoStatus(lotto, lottoNumberResult));
        System.out.println(lottoNumberResult);
    }

    public void createLottoStatus(Lotto lotto, StringBuilder lottoNumberResult) {
        lottoNumberResult.append(lotto.getNumbers().toString())
                .append(NEWLINE.getMessage());
    }

    public void printLottoPrize(LottoPrize lottoPrize) {
        StringBuilder lottoPrizeResult = new StringBuilder();
        createLottoPrizeStatS(lottoPrize, lottoPrizeResult);
        System.out.println(lottoPrizeResult);
    }

    public void createLottoPrizeStatS(LottoPrize lottoPrize, StringBuilder lottoPrizeResult) {
        lottoPrizeResult.append(STATS_MESSAGE.getMessage());
        lottoPrizeResult.append(String.format(WINNING_STATS_FIVE_RANK.getMessage(), lottoPrize.getFiveRankCount()));
        lottoPrizeResult.append(String.format(WINNING_STATS_FOUR_RANK.getMessage(), lottoPrize.getFourRankCount()));
        lottoPrizeResult.append(String.format(WINNING_STATS_THIRD_RANK.getMessage(), lottoPrize.getThirdRankCount()));
        lottoPrizeResult.append(String.format(WINNING_STATS_SECOND_RANK.getMessage(), lottoPrize.getSecondRankCount()));
        lottoPrizeResult.append(String.format(WINNING_STATS_FIRST_RANK.getMessage(), lottoPrize.getFirstRankCount()));
    }

    public void printLottoProfit(LottoProfit lottoProfit) {
        StringBuilder lottoProfitResult = new StringBuilder();
        createLottoProfitStats(lottoProfit, lottoProfitResult);
        System.out.println(lottoProfitResult);
    }

    public void createLottoProfitStats(LottoProfit lottoProfit, StringBuilder lottoProfitResult) {
        lottoProfitResult.append(String.format(WINNING_STATS_PROFIT_RATE.getMessage(), lottoProfit.getTotalProfitRate().getProfitRate()));
    }
}
