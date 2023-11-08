package lotto.view;

import lotto.domain.*;

import java.util.Arrays;

public class OutputView {
    private static final String LINE_SEPARATOR = "\n";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTIC_MESSAGE = "당첨 통계" + LINE_SEPARATOR + "---";
    private static final String COUNT_MESSAGE = "개";
    private static final String INCOME_RATE_MASSAGE = "총 수익률은 %.1f%%입니다.";


    public static void showQuantity(int quantity) {
        System.out.println(LINE_SEPARATOR + quantity + PURCHASE_MESSAGE);
    }

    public static void showLottoTickets(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.toString());
        }
    }

    public static void showLottoResult(Statistic statistic, Budget budget) {
        System.out.println(LINE_SEPARATOR + WINNING_STATISTIC_MESSAGE);

        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.LOSE))
                .forEach(rank -> System.out.println(resultMessage(rank, statistic)));

        System.out.printf(INCOME_RATE_MASSAGE, statistic.getRate(budget.getBudget()));
    }

    private static String resultMessage(Rank rank, Statistic statistic) {
        return rank.getMessage()
                + statistic.getRankCount(rank)
                + COUNT_MESSAGE;
    }

    public static void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
