package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private static final String PRINT_QUANTITY_MESSAGE = "개를 구매했습니다.";

    public static void printTicketQuantity(int ticketQuantity) {
        System.out.println(ticketQuantity + PRINT_QUANTITY_MESSAGE);
    }

    public static void printTickets(Tickets tickets) {
        for (Ticket ticket : tickets.getTickets()) {
            printTicket(ticket);
        }
    }

    private static void printTicket(Ticket ticket) {
        System.out.println(joinNumbers(ticket.getNumbers()));
    }

    private static String joinNumbers(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")) + "]";
    }
}
