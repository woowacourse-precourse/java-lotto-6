package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String SEPARATOR_MESSAGE = "---";
    private static final String FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    private static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String THIRD_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String FOURTH_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String FIFTH_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String UNIT_MESSAGE = "개";
    private static final String RATE_START_MESSAGE = "총 수익률은 ";
    private static final String RATE_END_MESSAGE = "%입니다.";


    public static void printTicketQuantity(int ticketQuantity) {
        System.out.println(ticketQuantity + QUANTITY_MESSAGE);
    }

    public static void printTickets(Tickets tickets) {
        for (Ticket ticket : tickets.getTickets()) {
            printTicket(ticket);
        }
    }

    private static void printTicket(Ticket ticket) {
        System.out.println(joinNumbers(sortTicketNumbers(ticket)));
    }

    private static List<Integer> sortTicketNumbers(Ticket ticket) {
        List<Integer> numbers = ticket.getNumbers();
        Collections.sort(numbers);
        return numbers;
    }

    private static String joinNumbers(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")) + "]";
    }

    public static void printWinningResult(Winning winning) {
        System.out.println(RESULT_MESSAGE + '\n' + SEPARATOR_MESSAGE);
        System.out.println(FIFTH_MESSAGE + winning.getFifthNumber() + UNIT_MESSAGE);
        System.out.println(FOURTH_MESSAGE + winning.getFourthNumber() + UNIT_MESSAGE);
        System.out.println(THIRD_MESSAGE + winning.getThirdNumber() + UNIT_MESSAGE);
        System.out.println(SECOND_MESSAGE + winning.getSecondNumber() + UNIT_MESSAGE);
        System.out.println(FIRST_MESSAGE + winning.getFirstNumber() + UNIT_MESSAGE);
    }

    public static void printRateOfProfit(Profit profit) {
        String rate = String.format("%.1f", profit.getRate());
        System.out.println(RATE_START_MESSAGE + rate + RATE_END_MESSAGE);
    }
}
