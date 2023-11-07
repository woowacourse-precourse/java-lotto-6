package lotto.view;

import java.util.List;

import static lotto.config.LottoConfig.LOTTO_FIFTH_NUMBER;
import static lotto.config.LottoConfig.LOTTO_FIRST_NUMBER;
import static lotto.config.LottoConfig.LOTTO_FOURTH_NUMBER;
import static lotto.config.LottoConfig.LOTTO_SECOND_NUMBER;
import static lotto.config.LottoConfig.LOTTO_SIXTH_NUMBER;
import static lotto.config.LottoConfig.LOTTO_THIRD_NUMBER;
import static lotto.config.LottoMessage.GRAPH_UNDER_BAR;
import static lotto.config.LottoMessage.LOTTO_BONUS_NUMBER_MESSAGE;
import static lotto.config.LottoMessage.LOTTO_NUMBER_MESSAGE;
import static lotto.config.LottoMessage.LOTTO_PURCHASE_CHECK_MESSAGE;
import static lotto.config.LottoMessage.LOTTO_PURCHASE_MESSAGE;
import static lotto.config.LottoMessage.LOTTO_STATISTICS_MESSAGE;
import static lotto.config.LottoMessage.LOTTO_TOTAL_PROFIT_MESSAGE;
import static lotto.config.LottoMessage.LOTTO_WINNING_NUMBER_MESSAGE;
import static lotto.config.LottoMessage.LOTTO_WINNING_RESULT_BONUS_MESSAGE;
import static lotto.config.LottoMessage.LOTTO_WINNING_RESULT_MESSAGE;


public class OutputView {

    public static void lottoPurchaseInputMessage() {
        System.out.println(LOTTO_PURCHASE_MESSAGE.getMessage());
    }

    public static void lottoPurchaseCheckOutputMessage(int lottoCount) {
        System.out.printf(LOTTO_PURCHASE_CHECK_MESSAGE.getMessage(), lottoCount);
    }

    public static void lottoNumberOutputMessage(List<Integer> lottoNumber) {
        System.out.printf(LOTTO_NUMBER_MESSAGE.getMessage(), lottoNumber.get(LOTTO_FIRST_NUMBER.getValue() - 1)
                , lottoNumber.get(LOTTO_SECOND_NUMBER.getValue() - 1)
                , lottoNumber.get(LOTTO_THIRD_NUMBER.getValue() - 1)
                , lottoNumber.get(LOTTO_FOURTH_NUMBER.getValue() - 1)
                , lottoNumber.get(LOTTO_FIFTH_NUMBER.getValue() - 1)
                , lottoNumber.get(LOTTO_SIXTH_NUMBER.getValue() - 1));
    }
    public static void lottoWinningNumberInputMessage() {
        System.out.println(LOTTO_WINNING_NUMBER_MESSAGE.getMessage());
    }

    public static void lottoBonusNumberInputMessage() {
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public static void lottoStatisticsOutputMessage() {
        System.out.println(LOTTO_STATISTICS_MESSAGE.getMessage());
    }

    public static void graphUnderBar() {
        System.out.println(GRAPH_UNDER_BAR.getMessage());
    }

    public static void lottoWinningResultOutputMessage(int number, int prize, int match) {
        System.out.printf(LOTTO_WINNING_RESULT_MESSAGE.getMessage(), number, prize, match);
    }

    public static void lottoWinningResultBonusOutputMessage(int number, int prize, int match) {
        System.out.printf(LOTTO_WINNING_RESULT_BONUS_MESSAGE.getMessage(), number, prize, match);
    }

    public static void lottoTotalProfitMessage(Double profit) {
        System.out.printf(LOTTO_TOTAL_PROFIT_MESSAGE.getMessage(), profit);
    }

    public static void newLine() {
        System.out.println();
    }

}
