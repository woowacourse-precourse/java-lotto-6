package lotto;

import java.util.Collections;
import java.util.List;
import static lotto.messages.LottoResultMessages.*;

public class LottoResultPrinter {
    public void printResult(List<Integer> matchingNumber, double totalSum) {
        System.out.println(RESULT_MESSAGE_HEADER.getMessage());
        System.out.println(RESULT_MESSAGE_SEPARATOR.getMessage());
        System.out.printf(RESULT_MESSAGE_3_MATCH.getMessage() + "\n", matchingNumber.get(3));
        System.out.printf(RESULT_MESSAGE_4_MATCH.getMessage() + "\n", matchingNumber.get(4));
        System.out.printf(RESULT_MESSAGE_5_MATCH.getMessage() + "\n", matchingNumber.get(5));
        System.out.printf(RESULT_MESSAGE_5_BONUS_MATCH.getMessage() + "\n", matchingNumber.get(0));
        System.out.printf(RESULT_MESSAGE_6_MATCH.getMessage() + "\n", matchingNumber.get(6));
        System.out.printf(RESULT_MESSAGE_TOTAL_INCOME.getMessage() + "\n", totalSum);
    }

//    public void printAllLotto(List<Integer> numbers) {
//        Collections.sort(numbers);
//        System.out.println(numbers);
//    }

    public void purchaseAllLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        System.out.println(lottoNumbers);
    }
}
