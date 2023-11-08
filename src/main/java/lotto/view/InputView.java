package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static final String BLANK_ERROR = "[ERROR] 공백은 입력할 수 없습니다.";
    private static final String FORMAT_ERROR = "[ERROR] 정수만 입력하세요.";

    public static int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return readPositiveInt();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return readString();
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return readPositiveInt();
    }

    private static String readString() {
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
        return input;
    }

    private static int readPositiveInt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR);
        }
    }
}