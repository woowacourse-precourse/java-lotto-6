package lotto.View.OutputView;

import static lotto.Model.RateReturn.ACTUAL_MATCH_NUMBER;
import static lotto.Model.RateReturn.VALID_MATCH_NUMBERS;
import static lotto.View.SystemMessage.RESULT_MATCHING_NUMBERS;

import java.util.Collections;
import java.util.List;
import lotto.View.SystemMessage;

public class PrintResult {

    private static final List<String> resultMessages = SystemMessage.getResultMessages();

    public static void printResult(List<Integer> winsCount) {
        getPrintResult(winsCount);
    }

    private static void getPrintResult(List<Integer> winsCount) {
        System.out.println(RESULT_MATCHING_NUMBERS.getMessage());
        for (int i = 0; i < VALID_MATCH_NUMBERS; i++) {
            int count = Collections.frequency(winsCount,i+ACTUAL_MATCH_NUMBER);
            System.out.printf(resultMessages.get(i),count);
        }
    }
}
