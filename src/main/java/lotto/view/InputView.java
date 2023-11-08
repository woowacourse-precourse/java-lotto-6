package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int askPrice() {
        try {
            String input = printHowManyPurchase();
            validateBlankAndEmptyInteger(input);
            return (validateNegativeIntegerAndZero(validateInteger(input)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askPrice();
        }
    }

    public String askWinningNumber() {
        try {
            String input = printWinningNumber();
            validateBlankAndEmptyInteger(input);
            validateFirstCharacter(input);
            validateLastCharacter(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askWinningNumber();
        }
    }

    public int askBonusWinningNumber() {
        try {
            String input = printBonusWinningNumber();
            validateBlankAndEmptyInteger(input);
            return validateInteger(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return askBonusWinningNumber();
        }
    }

    public void validateLastCharacter(String input) {
        if (!Character.isDigit(getCharacterAtIndex(input, input.length() - 1))) {
            throw new IllegalArgumentException("[ERROR] 문장은 마지막 문자를 숫자 외 허용하지 않습니다.");
        }
    }

    public void validateFirstCharacter(String input) {
        if (!Character.isDigit(getCharacterAtIndex(input, 0))) {
            throw new IllegalArgumentException("[ERROR] 문장은 첫번째 문자를 숫자 외 허용하지 않습니다.");
        }
    }

    private char getCharacterAtIndex(String input, int index) {
        if (index >= 0 && index < input.length()) {
            return input.charAt(index);
        }
        throw new IndexOutOfBoundsException("[ERROR] index 가 문자열의 범위를 벗어났습니다.");
    }

    private String printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private String printBonusWinningNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private String printHowManyPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    private int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 정수 외에는 입력받을 수 없습니다.");
        }
    }

    private void validateBlankAndEmptyInteger(String input) {
        if (input.isBlank() || input.isEmpty() || input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력될 수 없습니다.");
        }
    }

    private int validateNegativeIntegerAndZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 값은 입력받을 수 없습니다.");
        }
        return input;
    }
}
