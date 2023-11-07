package lotto.view;

import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    public List<Integer> splitSeperator() {
        String input = readLine();
        checkBlank(input);

        StringTokenizer st = new StringTokenizer(input, ",");
        List<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        return list;
    }
}
