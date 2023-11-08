package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserInteraction {
    private static String BUDGET_PROMPT = "구입금액을 입력해 주세요.";
    private static String ISSUED_LOTTO = "개를 구매했습니다.";
    private static String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static String BONUS_NUMBERS_PROMPT = "보너스 번호를 입력해 주세요.";
    private static String WINNING_STATISTIC = "당첨 통계\n---";
    private static String MATCH_SUFFIX = "개 일치";
    private static String BONUS_MATCH = ", 보너스 볼 일치";
    private static String REWARD_PREFIX = " (";
    private static String REWARD_SUFFIX = "원) - ";
    private static String COUNT_SUFFIX = "개";
    private static String RATE_OF_RETURN_PREFIX = "총 수익률은 ";
    private static String RATE_OF_RETURN_SUFFIX = "%입니다.";

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();

    private static final DecimalFormat formatter = new DecimalFormat("0.##");

    public static String promptBudget() {
        System.out.println(BUDGET_PROMPT);
        return Console.readLine();
    }

    public static void printTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + ISSUED_LOTTO);
        tickets.forEach(t -> {
            List<Integer> numbers = new ArrayList<>(t.getNumbers());
            numbers.sort(Integer::compare);
            System.out.println(numbers);
        });
    }

    public static String promptWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    public static String promptBonusNumber() {
        System.out.println(BONUS_NUMBERS_PROMPT);
        return Console.readLine();
    }

    public static void printWinningStatistic(Map<LottoRank, Integer> winningCount) {
        System.out.println(WINNING_STATISTIC);
        List<LottoRank> ranks = new ArrayList<>(winningCount.keySet());
        ranks.sort(LottoRank::compare);
        ranks.forEach(r -> {
            System.out.println(formatWinningResult(r, winningCount.getOrDefault(r, 0)));
        });
    }

    private static String formatWinningResult(LottoRank rank, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatch() + MATCH_SUFFIX);
        if (rank.getBonusRequired()) {
            sb.append(BONUS_MATCH);
        }
        sb.append(REWARD_PREFIX);
        sb.append(formatNumber(rank.getReward()));
        sb.append(REWARD_SUFFIX);
        sb.append(count);
        sb.append(COUNT_SUFFIX);
        return sb.toString();
    }

    private static String formatNumber(long number) {
        return numberFormat.format(number);
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.println(RATE_OF_RETURN_PREFIX +
                getPercentRepresentation(rateOfReturn) +
                RATE_OF_RETURN_SUFFIX);
    }

    private static String getPercentRepresentation(double input) {
        return formatter.format(input * 100);
    }
}
