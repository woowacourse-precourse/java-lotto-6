package lotto.view;

import lotto.model.WinningCriteria;
import java.util.List;

public class OutputView {
    private static final String LINE_SPACE = "\n";
    private static final String LINE_DIVIDER = "---";
    private static final String LOTTO_PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_STATISTICS = "당첨 통계" + LINE_SPACE + LINE_DIVIDER;
    private static List<WinningCriteria> orderPrintRank = List.of(
            WinningCriteria.FIFTH,
            WinningCriteria.FOURTH,
            WinningCriteria.THIRD,
            WinningCriteria.SECOND,
            WinningCriteria.FIRST
    );

    public void printLottoPurchaseInputMessage() {
        System.out.println(LOTTO_PURCHASE_INPUT_MESSAGE);
    }

    public void printLottoPurchaseCountMessage(int LottoPurchaseCount) {
        System.out.println(LottoPurchaseCount + LOTTO_PURCHASE_COUNT_MESSAGE);
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printLottoPurchasedNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printLottosStatics() {
        System.out.println(LOTTO_STATISTICS);
        for (WinningCriteria currentRank : orderPrintRank) {
            printLottoStatics();
        }
        printRateOfReturn();
    }

    private void printLottoStatics() {
    }

    private void printRateOfReturn() {
    }
}
