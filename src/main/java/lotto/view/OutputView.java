package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Rank;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String ASK_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String ASK_FOR_WINNING_NUMBERS = NEW_LINE + "당첨 번호를 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT = NEW_LINE + "%d개를 구매했습니다.";
    private static final String ASK_FOR_BONUS_NUMBER = NEW_LINE + "보너스 번호를 입력해 주세요.";
    private static final String THREE_MATCH = "3개 일치 (5,000원) - %d개";
    private static final String FOUR_MATCH = "4개 일치 (50,000원) - %d개";
    private static final String FIVE_MATCH = "5개 일치 (1,500,000원) - %d개";
    private static final String FIVE_MATCH_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String SIX_MATCH = "6개 일치 (2,000,000,000원) - %d개";
    private static final String TOTAL_PROFIT = "총 수익률은 %.1f%%입니다.";


    public void askForMoney() {
        System.out.println(ASK_FOR_MONEY);
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(String.format(PURCHASED_LOTTO_COUNT, lottoCount));
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            printCommaBetweenNumbers(numbers, i);
        }
        System.out.println("]");
    }

    private void printCommaBetweenNumbers(List<Integer> numbers, int i) {
        if (i != numbers.size() - 1) {
            System.out.print(", ");
        }
    }

    public void askForWinningNumbers() {
        System.out.println(ASK_FOR_WINNING_NUMBERS);
    }

    public void askForBonusNumber() {
        System.out.println(ASK_FOR_BONUS_NUMBER);
    }

    public void printWinningStatistics(Map<Rank, Integer> result) {
        System.out.println(NEW_LINE + "당첨 통계");
        System.out.println("---");
        System.out.println(String.format(THREE_MATCH, result.getOrDefault(Rank.FIFTH, 0)));
        System.out.println(String.format(FOUR_MATCH, result.getOrDefault(Rank.FOURTH, 0)));
        System.out.println(String.format(FIVE_MATCH, result.getOrDefault(Rank.THIRD, 0)));
        System.out.println(String.format(FIVE_MATCH_WITH_BONUS, result.getOrDefault(Rank.SECOND, 0)));
        System.out.println(String.format(SIX_MATCH, result.getOrDefault(Rank.FIRST, 0)));
    }

    public void printTotalProfit(double profit) {
        System.out.println(String.format(TOTAL_PROFIT, profit));
    }
}
