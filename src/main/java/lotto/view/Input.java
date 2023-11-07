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
        String input = readLine();
        manageException(input);

        return input;
    }

    private void manageException(String input) {
        checkBlank(input);
        validateNumber(input);
    }

    private void checkBlank(String input) {
        if (input.equals("") || input.equals(" ")) {
            inputException.isBlank();
        }
    }

    private void validateNumber(String input) {
        if (!isNatural(input)) {
            inputException.isNotNaturalNumber();
        }
    }

    private boolean isNatural(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }
}
