package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String TYPE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String COMMA = ", ";
    public static void printPurchaseAmount() {
        System.out.println(TYPE_PURCHASE_AMOUNT);
    }

    public static void printPurchaseCount(int count) {
        blankSpace();
        System.out.printf("%d개를 구매했습니다." , count);
    }

    public static void printPurchaseLottoList(List<Integer> numbers) {
        blankSpace();
        System.out.print(OPEN_BRACKET);
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(COMMA));
        System.out.print(result);
        System.out.print(CLOSE_BRACKET);
    }

    private static void blankSpace() {
        System.out.println();
    }

}
