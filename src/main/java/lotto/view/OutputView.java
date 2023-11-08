package lotto.view;

import lotto.domain.LottoRank;
import lotto.view.message.OutputMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String RETURNS_MESSAGE_LEFT = "총 수익률은 ";
    public static final String RETURNS_MESSAGE_RIGHT = "입니다.";
    public static final String COUNT_UNIT = "개";
    public static void printPurchaseCountResult(final int countOfPurchasable) {
        printMessage(countOfPurchasable + PURCHASE_MESSAGE);
    }

    public static void printGeneratedLottoResult(final List<Integer> generatedLotto) {
        String lottoResult = generatedLotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        printMessage("[" + lottoResult + "]");
    }

    public static void printWinningLottoResult(final LottoRank rank, final int count) {
        if (!rank.equals(LottoRank.NONE)) {
            printMessage(rank.getMessage() + count + COUNT_UNIT);
        }
    }

    public static void printReturnsResult(String lottoReturns) {
        printMessage(RETURNS_MESSAGE_LEFT+lottoReturns+RETURNS_MESSAGE_RIGHT);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
