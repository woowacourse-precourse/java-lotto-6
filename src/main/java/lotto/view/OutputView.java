package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String LOTTO_NUMBERS_CONNECTOR = ", ";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.printf(LOTTO_AMOUNT_MESSAGE, lottoAmount);
        System.out.println();
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        List<Integer> numbersInOrder = new ArrayList<>(numbers);
        Collections.sort(numbersInOrder);

        String numbersString = numbersInOrder.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_CONNECTOR));
        numbersString = String.format("%s%s%s", OPEN_BRACKET, numbersString, CLOSE_BRACKET);

        System.out.println(numbersString);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }
}