package lotto.view;

import lotto.model.WinningCriteria;
import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String LINE_SPACE = "\n";
    private static final String LINE_DIVIDER = "---";
    private static final String WINNING_INFO_SEPARATOR = " - ";
    private static final String WINNING_COUNT_UNIT = "개";
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
    private static final HashMap<WinningCriteria, String> rankMessages = new HashMap<>() {{
        put(WinningCriteria.FIRST, RankMessages.FIRST_RANK_MESSAGE);
        put(WinningCriteria.SECOND, RankMessages.SECOND_RANK_MESSAGE);
        put(WinningCriteria.THIRD, RankMessages.THIRD_RANK_MESSAGE);
        put(WinningCriteria.FOURTH, RankMessages.FOURTH_RANK_MESSAGE);
        put(WinningCriteria.FIFTH, RankMessages.FIFTH_RANK_MESSAGE);
    }};

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

    public void printLottoStatics(HashMap<WinningCriteria, Integer> winningRecords, double rateOfReturn) {
        System.out.println(LOTTO_STATISTICS);
        for (WinningCriteria currentRank : orderPrintRank) {
            printRankStatics(
                    rankMessages.get(currentRank),
                    winningRecords.getOrDefault(currentRank, 0)
            );
        }
        printRateOfReturn(rateOfReturn);
    }

    private void printRankStatics(String rankMessage, int winningRecords) {
        String printMessage = rankMessage
                + WINNING_INFO_SEPARATOR
                + winningRecords
                + WINNING_COUNT_UNIT;
        System.out.println(printMessage);
    }

    private void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
    }
}
