package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoPrize;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String TICKET_COUNT_MESSAGE ="개를 구매했습니다.";
    private static final String SYSTEM_MESSAGE_WINNING_STATIC = "당첨 통계";
    private static final String EARNING_RATE = "총 수익률은 %.1f%%입니다.";
    private static final String SYSTEM_MESSAGE_DASH = "---";
    public static void displayTicket_Count(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + TICKET_COUNT_MESSAGE);
    }

    public static void displayLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> sortedLottoNumbers = lotto.getNumbers().stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(sortedLottoNumbers);
        }
    }

    public static void displaySystemMessage() {
        System.out.println();
        System.out.println(SYSTEM_MESSAGE_WINNING_STATIC);
        System.out.println(SYSTEM_MESSAGE_DASH);
    }
    public static void displayLottoResult(EnumMap<LottoPrize, Integer> winCount) {
        LottoPrize[] prizesInOrder = {
                LottoPrize.THREE_MATCH,
                LottoPrize.FOUR_MATCH,
                LottoPrize.FIVE_MATCH,
                LottoPrize.FIVE_AND_BONUS_MATCH,
                LottoPrize.SIX_MATCH
        };

        for (LottoPrize prize : prizesInOrder) {
            int count = winCount.getOrDefault(prize, 0);
            System.out.println(prize.getDescription() + " (" + String.format("%,d", prize.getPrize()) + "원) - " + count + "개");
        }
    }

    public static void displayEarningsRate(double profitRate) {
        System.out.printf(EARNING_RATE, profitRate);
    }
}
