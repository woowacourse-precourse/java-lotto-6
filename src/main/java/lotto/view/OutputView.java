package lotto.view;

import static lotto.domain.enumerate.Rank.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.enumerate.Rank;
import lotto.message.ConsoleMessage;

public class OutputView {
    private static final String LOTTO_PRINT_FRONT  = "[";
    private static final String LOTTO_SEPERATOR = ", ";
    private static final String LOTTO_PRINT_END = "]";
    public static void printErrorMessage(String message) {
        System.out.println(ConsoleMessage.ERROR_STRING.getMessage() + message);
    }
    public static void printPurchaseCount(int count) {
        System.out.println(count + ConsoleMessage.CREATE_LOTTOS_COUNT.getMessage());
    }

    public static void printLottos(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(printPerlotto(lotto));
        }
        System.out.println();
    }

    private static void printLottoResultMessage() {
        System.out.println(ConsoleMessage.PRINT_LOTTO_RESULT.getMessage());
        System.out.println(ConsoleMessage.PRINT_SEPERATE_STRING.getMessage());
    }

    public static void printLottoResult(Map<Rank, Integer> ranks, double rate) {
        printLottoResultMessage();

        System.out.println(ConsoleMessage.PRINT_5_RANK_RESULT.getMessage() + ranks.getOrDefault(FIFTH, 0) + "개");
        System.out.println(ConsoleMessage.PRINT_4_RANK_RESULT.getMessage() + ranks.getOrDefault(FOURTH, 0)+ "개");
        System.out.println(ConsoleMessage.PRINT_3_RANK_RESULT.getMessage() + ranks.getOrDefault(THIRD, 0)+ "개");
        System.out.println(ConsoleMessage.PRINT_2_RANK_RESULT.getMessage() + ranks.getOrDefault(SECOND, 0)+ "개");
        System.out.println(ConsoleMessage.PRINT_1_RANK_RESULT.getMessage() + ranks.getOrDefault(FIRST, 0)+ "개");

        System.out.println(ConsoleMessage.PRINT_TOTAL_RESULT.getMessage() +
                rate + ConsoleMessage.PRINT_TOTAL_RESULT_END_WORD.getMessage());
    }


    private static String printPerlotto(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LOTTO_PRINT_FRONT);

        List<Integer> sortedList = sortLotto(lotto);

        for(Integer number : sortedList) {
            stringBuilder.append(number);
            stringBuilder.append(LOTTO_SEPERATOR);
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(LOTTO_PRINT_END);
        return stringBuilder.toString();
    }

    private static List<Integer> sortLotto(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(numbers);
        return numbers;
    }

}
