package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String COMMA = ", ";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String ASK_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String ASK_FOR_WINNING_NUMBERS = NEW_LINE + "당첨 번호를 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT = NEW_LINE + "%d개를 구매했습니다.";
    private static final String ASK_FOR_BONUS_NUMBER = NEW_LINE + "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = NEW_LINE + "당첨 통계";
    private static final String WINNING_STATISTICS_HEADER = "---";
    private static final String TOTAL_PROFIT = "총 수익률은 %.1f%%입니다.";
    private static final int DEFAULT_RESULT = 0;


    public void askForMoney() {
        System.out.println(ASK_FOR_MONEY);
    }

    public void printLottoCount(int lottoCount) {
        System.out.printf(PURCHASED_LOTTO_COUNT + NEW_LINE, lottoCount);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.print(OPEN_BRACKET);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            printCommaBetweenNumbers(numbers, i);
        }
        System.out.println(CLOSE_BRACKET);
    }

    private void printCommaBetweenNumbers(List<Integer> numbers, int i) {
        if (i != numbers.size() - 1) {
            System.out.print(COMMA);
        }
    }

    public void askForWinningNumbers() {
        System.out.println(ASK_FOR_WINNING_NUMBERS);
    }

    public void askForBonusNumber() {
        System.out.println(ASK_FOR_BONUS_NUMBER);
    }

    public void printWinningStatistics(Map<Rank, Integer> result) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(WINNING_STATISTICS_HEADER);
        for (Rank rank : Rank.values()) {
            if (isMissRank(rank)) {
                continue;
            }
            System.out.printf(rank.getMessage() + NEW_LINE, result.getOrDefault(rank, DEFAULT_RESULT));
        }
    }

    private boolean isMissRank(Rank rank) {
        return rank == Rank.MISS;
    }

    public void printTotalProfit(double profit) {
        System.out.printf((TOTAL_PROFIT) + NEW_LINE, profit);
    }
}
