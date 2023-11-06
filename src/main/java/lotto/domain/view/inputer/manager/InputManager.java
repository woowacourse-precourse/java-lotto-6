package lotto.domain.view.inputer.manager;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.util.validator.InputValidator;

public class InputManager {
    private static final String COMMA = ",";

    private InputManager() {
    }

    public static String getReadLineWithTrim() {
        String userInput = Console.readLine();
        System.out.println();

        return userInput.trim();
    }

    public static List<Integer> getNumbersByInput(String input) {
        InputValidator.validateNumberOrComma(input);
        String[] numbers = input.split(COMMA);
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }


}
