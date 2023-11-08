package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String PRINT_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_RESULT_MESSAGE = "당첨 통계";
    private static final String PRINT_SEPARATOR = "---";
    private static final String PRINT_FIRST = "6개 일치 (2,000,000,000원) - ";
    private static final String PRINT_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_THIRD = "5개 일치 (1,500,000원) - ";
    private static final String PRINT_FOURTH = "4개 일치 (50,000원) - ";
    private static final String PRINT_FIFTH = "3개 일치 (5,000원) - ";
    private static final String PRINT_UNIT = "개";


    public static void printTicketQuantity(int ticketQuantity) {
        System.out.println(ticketQuantity + PRINT_QUANTITY_MESSAGE);
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
        System.out.println(PRINT_RESULT_MESSAGE + '\n' + PRINT_SEPARATOR);
        System.out.println(PRINT_FIFTH + winning.getFifthNumber() + PRINT_UNIT);
        System.out.println(PRINT_FOURTH + winning.getFourthNumber() + PRINT_UNIT);
        System.out.println(PRINT_THIRD + winning.getThirdNumber() + PRINT_UNIT);
        System.out.println(PRINT_SECOND + winning.getSecondNumber() + PRINT_UNIT);
        System.out.println(PRINT_FIRST + winning.getFirstNumber() + PRINT_UNIT);
    }
}
