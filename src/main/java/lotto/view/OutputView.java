package lotto.view;

import lotto.config.LottoMessage;

import java.util.List;

import static lotto.config.LottoMessage.*;

public class OutputView {

    public static void lottoPurchaseInputMessage() {
        System.out.println(LOTTO_PURCHASE_MESSAGE.getMessage());
    }

    public static void lottoPurchaseCheckOutputMessage(int lottoCount) {
        System.out.printf(LOTTO_PURCHASE_CHECK_MESSAGE.getMessage(), lottoCount);
    }

    public static void lottoNumbersOutputMessage(List<Integer> lottoNumber) {
        System.out.println(LOTTO_NUMBER_MESSAGE.getMessage());
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

    public static void lottoWinningResultOutputMessage() {
        System.out.println(LOTTO_WINNING_RESULT_MESSAGE.getMessage());
    }

}
