package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.InputValidator;

public class ConsoleInput implements Input {
    private InputValidator inputValidator;

    public ConsoleInput() {
        inputValidator = new InputValidator();
    }

    public int getPrice() {
        String inputPrice = Console.readLine();
        inputValidator.validatePrice(inputPrice);

        return parseNumber(inputPrice);
    }

    private static int parseNumber(String inputPrice) {
        return Integer.parseInt(inputPrice);
    }
}
