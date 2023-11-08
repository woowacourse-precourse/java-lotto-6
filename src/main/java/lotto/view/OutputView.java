package lotto.view;

import static lotto.domain.MatchingCase.FIVE_MATCHING_WITH_BONUS;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MatchingCase;

public class OutputView {
    public static final String NEW_LINE = System.lineSeparator();
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] ";

    private OutputView() {
    }

    public static void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다." + NEW_LINE, count);
    }

    public static void printLottoCollection(List<Lotto> lottoCollection) {
        for (Lotto lotto : lottoCollection) {
            System.out.println(lotto.toString());
        }
    }

    public static void printResult(List<MatchingCase> matchingCaseGroup) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (MatchingCase matchingCase : matchingCaseGroup) {
            generateResultMessage(matchingCase);
        }
    }

    private static void generateResultMessage(MatchingCase matchingCase) {
        int matchingValue = matchingCase.getMatchingValue();
        String prize = String.format("%,d", matchingCase.getPrize());
        int winningCount = matchingCase.getWinningCount();

        if (matchingCase != FIVE_MATCHING_WITH_BONUS) {
            System.out.printf("%d개 일치 (%s원) - %d개" + NEW_LINE, matchingValue, prize, winningCount);
        }
        if (matchingCase == FIVE_MATCHING_WITH_BONUS) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개" + NEW_LINE, matchingValue, prize, winningCount);
        }
    }

    public static void printProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }

    public static void printExceptionMessage(String message) {
        System.out.println(ERROR_MESSAGE_FORMAT + message);
    }
}
