package lotto;

import java.util.Collections;
import java.util.List;
import static lotto.messages.LottoResultMessages.*;

public class LottoResultPrinter {
    public void printResult(List<Integer> matchingNumber, long userCost) {
        long totalSum = matchingNumber.get(3) * 5_000 +
                matchingNumber.get(4) * 50_000 +
                matchingNumber.get(5) * 1_500_000 +
                matchingNumber.get(6) * 2_000_000_000 +
                matchingNumber.get(0) * 30_000_000;
        double totalResult = (double) totalSum / userCost * 100;
        System.out.println(RESULT_MESSAGE_HEADER.getMessage());
        System.out.println(RESULT_MESSAGE_SEPARATOR.getMessage());
        System.out.printf(RESULT_MESSAGE_3_MATCH.getMessage() + "\n", matchingNumber.get(3));
        System.out.printf(RESULT_MESSAGE_4_MATCH.getMessage() + "\n", matchingNumber.get(4));
        System.out.printf(RESULT_MESSAGE_5_MATCH.getMessage() + "\n", matchingNumber.get(5));
        System.out.printf(RESULT_MESSAGE_5_BONUS_MATCH.getMessage() + "\n", matchingNumber.get(0));
        System.out.printf(RESULT_MESSAGE_6_MATCH.getMessage() + "\n", matchingNumber.get(6));
        System.out.printf(RESULT_MESSAGE_TOTAL_INCOME.getMessage() + "\n", totalResult);
    }

    public void printAllLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }
}
