package lotto.util;

import static lotto.constant.message.ErrorMessage.BLANK_LINE;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputUtil {
    public static String getUserInput() throws NoSuchElementException {
        while (true) {
            String input = Console.readLine();
            try {
                validateEmptyLine(input);
                return input;
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void validateEmptyLine(String input) {
        if (input.trim().isEmpty()) {
            throw new NoSuchElementException(BLANK_LINE);
        }
    }
}
