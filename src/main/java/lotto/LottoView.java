package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoView {

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
            throw new NumberFormatException("[ERROR] 숫자가 아닙니다.");
        }

        return number;
    }

}
