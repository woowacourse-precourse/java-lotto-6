package lotto.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.handler.ExceptionHandler;

public class LottoTicket {
    private static final int LOTTO_NUMBER_SIZE = 6;

    public static List<List<Integer>> lottoTicket(int count) {
        List<Integer> numbers = null;
        List<List<Integer>> ticketBundle = new ArrayList<>();

        updateNumbers(count, ticketBundle);

        return ticketBundle;
    }

    public static void printTickets(List<List<Integer>> ticketBundle) {
        for (List<Integer> ticket : ticketBundle) {
            System.out.println(ticket);
        }
    }

    private static void compareSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("Lottery number size must be 6. \n └─ errorVar : " + numbers.size());
        }
    }

    private static List<List<Integer>> updateNumbers(int count, List<List<Integer>> ticketBundle) {
        for (int i = 0; i < count; i++) {
            generateAndAddValidNumbers(ticketBundle);
        }

        return ticketBundle;
    }

    private static void generateAndAddValidNumbers(List<List<Integer>> ticketBundle) {
        while (true) {
            try {
                List<Integer> numbers = generateNumbers();
                compareSize(numbers);
                Collections.sort(numbers);
                ticketBundle.add(new ArrayList<>(numbers));
                return;
            } catch (IllegalArgumentException e) {
                ExceptionHandler.handle(e);
            }
        }
    }


    private static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            int number;
            do {
                number = Randoms.pickNumberInRange(1, 45);
            } while (numbers.contains(number));
            numbers.add(number);
        }
        return numbers;
    }
}
