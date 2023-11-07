package lotto.view;

import lotto.constant.Error;
import lotto.exception.InputException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    private static Input input = new Input();
    private Output output = Output.getOutput();

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
        try {
            checkBlank(input);
            validateNumber(input);
            endWithSeparator(input);
        } catch (IllegalArgumentException e) {
            inputFromUser();
        }
    }

    private void manageSeperatorInputException(String input) {
        try {
            checkBlank(input);
            endWithSeparator(input);
        } catch (IllegalArgumentException e) {
            inputFromUser();
        }
    }

    private void checkBlank(String input) {
        if (input.equals("") || input.equals(" ")) {
            new InputException(Error.IS_BRANK);
        }
    }

    private void validateNumber(String input) {
        if (!isNatural(input)) {
            new InputException(Error.ABLE_NUMBER);
        }
    }

    private void endWithSeparator(String input) {
        if (input.endsWith(",")) {
            new InputException(Error.ENDS_WITH_SEPARATOR);
        }
    }

    private boolean isNatural(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    public List<Integer> splitSeperator() {
        String input = readLine();
        manageSeperatorInputException(input);

        StringTokenizer st = new StringTokenizer(input, ",");
        List<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        return list;
    }

}
