package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constants.RankConstants;

public class OutputView {
    public static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String RETURNS_MESSAGE_LEFT = "총 수익률은 ";
    public static final String RETURNS_MESSAGE_RIGHT = "입니다.";
    public static final String COUNT_UNIT = "개";
    public static final String STATISTICS_MESSAGE = "당첨 통계\n---";

    public static void printPurchaseCountResult(final int countOfPurchasable) {
        printMessage(countOfPurchasable + PURCHASE_MESSAGE);
    }

    public static void printGeneratedLottoResult(final List<Integer> generatedLotto) {
        String lottoResult = generatedLotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        printMessage("[" + lottoResult + "]");
    }

    public static void printWinningLottoResult(final RankConstants rank, final int count) {
        if (!rank.equals(RankConstants.NONE)) {
            printMessage(rank.getMessage() + count + COUNT_UNIT);
        }
    }

    public static void printReturnsResult(String lottoReturns) {
        printMessage(RETURNS_MESSAGE_LEFT + lottoReturns + RETURNS_MESSAGE_RIGHT);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void newLine() {
        System.out.println();
    }
}
