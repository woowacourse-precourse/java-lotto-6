package lotto;

import java.util.List;

public class OutputView {
    public static void printLottoTickets(List<Integer> numbers) {
        System.out.print("[");
        for (int j = 0; j < numbers.size(); j++) {
            if (j == numbers.size() - 1) {
                System.out.println(numbers.get(j) + "]");
                break;
            }
            System.out.print(numbers.get(j) + ", ");
        }
    }
}
