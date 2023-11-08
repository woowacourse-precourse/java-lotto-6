package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Number {
    private final static String NOT_NUMBER_ERROR = "[ERROR] 숫자를 입력해 주세요.";

    private final int number;

    Number(String input) {
        this.number = validate(input);
    }

    private int validate(String input) {
        return validateNumber(input);
    }

    private int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(NOT_NUMBER_ERROR);
            return Integer.parseInt(readLine());
        }
    }

    public int getNumber() {
        return number;
    }
}
