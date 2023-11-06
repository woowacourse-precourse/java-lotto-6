package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

    private static final String ERROR_NOT_NUMBER = Message.ERROR_NOT_NUMBER.getValue();

    int inputNumber(String message) {

        printMessage(message);
        String input = readLine();

        return getStringToInt(input);
    }

    void printMessage(String message) {
        System.out.println(message);
    }

    private int getStringToInt(String input) {

        int number;

        try {
            number = Integer.parseInt(input);

        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(ERROR_NOT_NUMBER);
        }

        return number;
    }

}
