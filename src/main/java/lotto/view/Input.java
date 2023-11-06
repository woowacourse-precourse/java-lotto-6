package lotto.view;

import lotto.exception.InputException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    private static Input input = new Input();

    private InputException inputException = InputException.getInputException();

    private Input() {
    }

    public static Input getInput() {
        return input;
    }

    public String inputFromUser() {
        String input = checkBlank();
        validNaturalNumber(input);

        return input;
    }

    private String checkBlank() {
        String value = readLine();

        if (value == null) {
            inputException.isBlank();
        }

        return value;
    }

    private void validNaturalNumber(String input) {
        boolean isNatural = input.chars()
                .allMatch(Character::isDigit);

        if (!isNatural) {
            inputException.isNotNaturalNumber();
        }
    }

}
