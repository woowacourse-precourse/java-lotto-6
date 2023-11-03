package lotto.view;

import java.util.List;
import lotto.model.User;
import lotto.validator.LottoValidator;

public class OutputView {
    private static String COUNT = "%d개를 구매했습니다.";
    private static String TICKET = "[" + "%s" + "]";

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
        int lottoSize = LottoValidator.SIZE;
        for (int i = 0; i < lottoSize; i++) {
            ticket.append(numbers.get(i));
            if (i < lottoSize - 1) {
                ticket.append(", ");
            }
        }
        System.out.printf((TICKET) + "%n", ticket);
    }


}
