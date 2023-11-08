package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String LOTTO_TICKET_AMOUNT = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DIVIDED_LINE = "---";
    private static final String THREE_MATCHES = "3개 일치 (5,000원) ";
    private static final String FOUR_MATCHES = "4개 일치 (50,000원) ";
    private static final String FIVE_MATCHES = "5개 일치 (1,500,000원) ";
    private static final String FIVE_AND_BONUS_MATCHES = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    private static final String SIX_MATCHES = "6개 일치 (2,000,000,000원) ";
    private static final String HYPHEN = "-";
    private static final String COUNT_UNIT = "개";
    private static final String TOTAL_INCOME_RATE_PREFIX = "총 수익률은 ";
    private static final String TOTAL_INCOME_RATE_SUFFIX = "입니다.";

    public static void printTicketAmountAndEachRandomNumbers(int ticketAmount, List<Lotto> randomLottoNumbers) {
        System.out.println(ticketAmount + LOTTO_TICKET_AMOUNT);
        printEachRandomNumbers(randomLottoNumbers);
    }

    private static void printEachRandomNumbers(List<Lotto> randomLottoNumbers) {
        for (Lotto randomLottoNumber : randomLottoNumbers) {
            System.out.println(randomLottoNumber);
        }
    }

    public static void printWinningStatistics(Map<> winningResult) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDED_LINE);
        System.out.println(THREE_MATCHES + HYPHEN + COUNT_UNIT);
        System.out.println(FOUR_MATCHES + HYPHEN + COUNT_UNIT);
        System.out.println(FIVE_MATCHES + HYPHEN + COUNT_UNIT);
        System.out.println(FIVE_AND_BONUS_MATCHES + HYPHEN + COUNT_UNIT);
        System.out.println(SIX_MATCHES + HYPHEN + COUNT_UNIT);
    }

    public static void printIncomeRate(String incomeRate) {
        System.out.println(TOTAL_INCOME_RATE_PREFIX + incomeRate + TOTAL_INCOME_RATE_SUFFIX);
    }


}
