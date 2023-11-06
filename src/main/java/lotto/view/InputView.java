package lotto.view;

import static lotto.constant.message.ErrorMessage.BLANK_LINE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Converter;

public class InputView {

    public int requestNumberInput(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = Console.readLine();
                validateEmptyLine(input);
                return Converter.convertInteger(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> requestListInput(String message) {
        while (true) {
            try {
                System.out.println(message);
                String input = Console.readLine();
                validateEmptyLine(input);
                return Converter.convertIntegerList(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateEmptyLine(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_LINE.getMessage());
        }
    }


}
