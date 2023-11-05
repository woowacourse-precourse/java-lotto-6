package lotto.view;

import java.util.List;

import static lotto.config.LottoConfig.*;
import static lotto.config.LottoMessage.*;

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

    public static void lottoWinningResultOutputMessage() {
        System.out.println(LOTTO_WINNING_RESULT_MESSAGE.getMessage());
    }

    public static void newLine() {
        System.out.println();
    }

}
