package lotto.view;

import static lotto.model.LottoPrize.FIRST_PRIZE;
import static lotto.model.LottoPrize.SECOND_PRIZE;
import static lotto.model.LottoPrize.THIRD_PRIZE;
import static lotto.model.LottoPrize.FOURTH_PRIZE;
import static lotto.model.LottoPrize.FIFTH_PRIZE;
import static lotto.util.Constant.THREE;
import static lotto.util.Constant.FOUR;
import static lotto.util.Constant.FIVE;
import static lotto.util.Constant.SIX;
import static lotto.util.Converter.formatNumberWithComma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    private static final String HYPHEN = " - ";
    private static final String THREE_HYPHENS = "---";
    private static final String MONEY_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String FIRST_PRIZE_MESSAGE =
            SIX.getValue() + "개 일치, 보너스 볼 일치 " + "(" + formatNumberWithComma(FIRST_PRIZE.getPrize()) + "원" + ")"
                    + HYPHEN;
    private static final String SECOND_PRIZE_MESSAGE =
            FIVE.getValue() + "개 일치, 보너스 볼 일치 " + "(" + formatNumberWithComma(SECOND_PRIZE.getPrize()) + "원" + ")"
                    + HYPHEN;
    private static final String THIRD_PRIZE_MESSAGE =
            FIVE.getValue() + "개 일치 " + "(" + formatNumberWithComma(THIRD_PRIZE.getPrize()) + "원" + ")" + HYPHEN;
    private static final String FOURTH_PRIZE_MESSAGE =
            FOUR.getValue() + "개 일치 " + "(" + formatNumberWithComma(FOURTH_PRIZE.getPrize()) + "원" + ")" + HYPHEN;
    private static final String FIFTH_PRIZE_MESSAGE =
            THREE.getValue() + "개 일치 " + "(" + formatNumberWithComma(FIFTH_PRIZE.getPrize()) + "원" + ")" + HYPHEN;
    private static final String COUNT = "개";

    @Override
    public void printMoneyRequestMessage() {
        System.out.println(MONEY_REQUEST_MESSAGE);
    }

    @Override
    public void printPurchasedLottos(final List<List<Integer>> lottos) {
        printNewLine();
        System.out.println(lottos.size() + PURCHASED_LOTTO_MESSAGE);
        for (final List<Integer> lotto : lottos) {
            List<Integer> purchasedLotto = new ArrayList<>(lotto);
            Collections.sort(purchasedLotto);
            System.out.println(purchasedLotto);
        }
    }

    @Override
    public void printWinningNumberRequestMessage() {
        printNewLine();
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
    }

    @Override
    public void printBonusNumberRequestMessage() {
        printNewLine();
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }

    @Override
    public void printWinningStatistics(final int firstPrizeCount, final int secondPrizeCount, final int thirdPrizeCount,
                                       final int fourthPrizeCount, final int fifthPrizeCount) {
        printNewLine();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(THREE_HYPHENS);
        System.out.println(FIFTH_PRIZE_MESSAGE + fifthPrizeCount + COUNT);
        System.out.println(FOURTH_PRIZE_MESSAGE + fourthPrizeCount + COUNT);
        System.out.println(THIRD_PRIZE_MESSAGE + thirdPrizeCount + COUNT);
        System.out.println(SECOND_PRIZE_MESSAGE + secondPrizeCount + COUNT);
        System.out.println(FIRST_PRIZE_MESSAGE + firstPrizeCount + COUNT);
    }

    @Override
    public void printTotalProfit(long totalPrize, final long money) {
        double totalProfit = ((double) totalPrize / money * 100);
        System.out.println("총 수익률은" + String.format("%.2f", totalProfit) + "%" + "입니다.");
    }

    private void printNewLine() {
        System.out.println();
    }
}
