package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PRICE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String requestPrice() {
        System.out.println(PRICE_REQUEST_MESSAGE);

        return reqeustInput();
    }

    public static String requestNumbers() {
        System.out.println(NUMBERS_REQUEST_MESSAGE);

        return reqeustInput();
    }

    public static String requestBonus() {
        printWhiteSpace();
        System.out.println(BONUS_REQUEST_MESSAGE);

        return reqeustInput();
    }

    private static String reqeustInput() {
        return Console.readLine();
    }

    private static void printWhiteSpace() {
        System.out.println();
    }
}
