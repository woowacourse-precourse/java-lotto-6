package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ASK_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_WINNING_NUMBER_MESSAGE = "[ERROR] 보너스 번호를 입력해 주세요.";
    private static final String START_OF_SENTENCE_CHARACTER = "[ERROR] 문장은 첫번째 문자를 숫자 외 허용하지 않습니다.";
    private static final String END_OF_SENTENCE_CHARACTER = "[ERROR] 문장은 마지막 문자를 숫자 외 허용하지 않습니다.";
    public static final String PERMIT_ONLY_NUMBER = "[ERROR] 정수 외에는 입력받을 수 없습니다.";
    public static final String NO_PERMIT_BLANK = "[ERROR] 공백은 입력될 수 없습니다.";
    public static final String NO_PERMIT_INPUT_LESS_ZERO = "[ERROR] 0 이하의 값은 입력받을 수 없습니다.";

    public int askPrice() {
        printHowManyPurchase();
        String input = Console.readLine();
        validateBlankAndEmptyInteger(input);
        return validateNegativeIntegerAndZero(validateInteger(input));
    }

    public void validateLastCharacter(String input) {
        char lastCharacter = getLastCharacter(input);

        if (!Character.isDigit(lastCharacter)) {
            throw new IllegalArgumentException(END_OF_SENTENCE_CHARACTER);
        }
    }

    public void validateFirstCharacter(String input) {
        char firstCharacter = getFirstCharacter(input);

        if (!Character.isDigit(firstCharacter)) {
            throw new IllegalArgumentException(START_OF_SENTENCE_CHARACTER);
        }
    }

    private char getFirstCharacter(String input) {
        char lastCharacter = input.toCharArray()[0];
        return lastCharacter;
    }

    private char getLastCharacter(String input) {
        char lastCharacter = input.toCharArray()[input.length() - 1];
        return lastCharacter;
    }

    private void printWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
    }

    private void printBonusWinningNumber() {
        System.out.println(ASK_BONUS_WINNING_NUMBER_MESSAGE);
    }

    private void printHowManyPurchase() {
        System.out.println(ASK_PURCHASE_MESSAGE);
    }

    private int validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(PERMIT_ONLY_NUMBER);
        }
        return Integer.parseInt(input);
    }

    private void validateBlankAndEmptyInteger(String input) {
        if (input.isBlank() || input.isEmpty() || input.contains(" ")) {
            throw new IllegalArgumentException(NO_PERMIT_BLANK);
        }
    }

    private int validateNegativeIntegerAndZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(NO_PERMIT_INPUT_LESS_ZERO);
        }
        return input;
    }
}
