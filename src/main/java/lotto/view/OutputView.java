package lotto.view;

import static lotto.enums.NumberCondition.LOTTO_SIZE;
import static lotto.enums.NumberCondition.LOWEST_PRIZE_RANK;

import java.util.Collections;
import java.util.List;
import lotto.model.User;
import lotto.utils.Converter;

public class OutputView {
    private static final String COUNT = "%d개를 구매했습니다.";
    private static final String TICKET = "[" + "%s" + "]";
    private static final String NUMBER_DIVISOR = ", ";
    private static final String PRIZE_DETAILS = "당첨 통계";
    private static final String LINE = "---";
    private static final String NTH_PRIZE_DETAIL = "%d개 일치 (%d원) - %d개";
    private static final String NTH_PRIZE_DETAIL_CONTAINING_BONUS = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";

    public static void printCountAndTickets(User user, int count) {
        printCount(count);
        printTickets(user, count);
    }

    public static void printCount(int count) {
        System.out.printf((COUNT) + "%n", count);
    }

    public static void printTickets(User user, int count) {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = user.getTicket(i);
            printTicket(numbers);
        }
    }

    private static void printTicket(List<Integer> numbers) {
        StringBuilder ticket = new StringBuilder();
        int lottoSize = LOTTO_SIZE.number();
        Collections.sort(numbers);
        for (int i = 0; i < lottoSize; i++) {
            ticket.append(numbers.get(i));
            if (i < lottoSize - 1) {
                ticket.append(NUMBER_DIVISOR);
            }
        }
        System.out.printf((TICKET) + "%n", ticket);
    }

    public static void printPrizeDetails(int[] nthPrizeNumber) {
        System.out.println(PRIZE_DETAILS);
        System.out.println(LINE);
        for (int rank = LOWEST_PRIZE_RANK.number(); rank > 0; rank--) {
            int prizeNumber = nthPrizeNumber[rank];
            printPrizeDetail(prizeNumber, rank);
        }
    }

    private static void printPrizeDetail(int prizeNumber, int rank) {
        if (rank != 2) {
            System.out.printf((NTH_PRIZE_DETAIL) + "%n",
                    Converter.rankToSameNumbers(rank),
                    Converter.rankToPrize(rank),
                    prizeNumber);
        }
        if (rank == 2) {
            System.out.printf((NTH_PRIZE_DETAIL_CONTAINING_BONUS) + "%n",
                    Converter.rankToSameNumbers(rank),
                    Converter.rankToPrize(rank),
                    prizeNumber);
        }
    }
}
