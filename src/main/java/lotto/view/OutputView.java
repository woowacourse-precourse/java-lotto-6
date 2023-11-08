package lotto.view;

import static lotto.enums.NumberCondition.LOTTO_SIZE;
import static lotto.enums.NumberCondition.LOWEST_PRIZE_RANK;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import lotto.model.User;
import lotto.utils.Converter;

public class OutputView {
    private static final String COUNT = "%d개를 구매했습니다.";
    private static final String TICKET = "[" + "%s" + "]";
    private static final String NUMBER_DIVISOR = ", ";
    private static final String PRIZE_DETAILS = "당첨 통계";
    private static final String LINE = "---";
    private static final String NTH_PRIZE_DETAIL = "%d개 일치 (%s원) - %d개";
    private static final String NTH_PRIZE_DETAIL_CONTAINING_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RETURN_RATE = "총 수익률은 %s%%입니다.";

    public static void printCountAndTickets(User user, int count) {
        System.out.println();
        printCount(count);
        printTickets(user, count);
    }

    public static void printCount(int count) {
        System.out.printf((COUNT) + "%n", count);
    }

    public static void printTickets(User user, int count) {
        for (int index = 0; index < count; index++) {
            List<Integer> numbers = user.getTicket(index);
            printTicket(numbers);
        }
    }

    private static void printTicket(List<Integer> numbers) {
        StringBuilder ticket = new StringBuilder();
        int lottoSize = LOTTO_SIZE.number();
        int[] sortedNumbers = sortNumbers(numbers, lottoSize);
        for (int index = 0; index < lottoSize; index++) {
            ticket.append(sortedNumbers[index]);
            if (index < lottoSize - 1) {
                ticket.append(NUMBER_DIVISOR);
            }
        }
        System.out.printf((TICKET) + "%n", ticket);
    }

    private static int[] sortNumbers(List<Integer> numbers, int lottoSize) {
        int[] sortedNumbers = new int[lottoSize];
        for (int index = 0; index < lottoSize; index++) {
            sortedNumbers[index] = numbers.get(index);
        }
        Arrays.sort(sortedNumbers);
        return sortedNumbers;
    }

    public static void printPrizeDetails(int[] nthPrizeNumber) {
        System.out.println();
        System.out.println(PRIZE_DETAILS);
        System.out.println(LINE);
        for (int rank = LOWEST_PRIZE_RANK.number(); rank > 0; rank--) {
            int prizeNumber = nthPrizeNumber[rank];
            printPrizeDetail(prizeNumber, rank);
        }
    }

    private static void printPrizeDetail(int prizeNumber, int rank) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        int prize = Converter.rankToPrizeMoney(rank);
        String prizeWithComma = decimalFormat.format(prize);
        if (rank != 2) {
            System.out.printf((NTH_PRIZE_DETAIL) + "%n",
                    Converter.rankToSameNumbers(rank),
                    prizeWithComma, prizeNumber);
        }
        if (rank == 2) {
            System.out.printf((NTH_PRIZE_DETAIL_CONTAINING_BONUS) + "%n",
                    Converter.rankToSameNumbers(rank),
                    prizeWithComma, prizeNumber);
        }
    }

    public static void printReturnRate(BigDecimal returnRate) {
        System.out.printf((RETURN_RATE) + "%n", returnRate.toString());
    }
}
