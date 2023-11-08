package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class InputManager {
    public int inputBudget() {
        String input;

        while (true) {
            try {
                input = Console.readLine();
                validateInputBudget(input);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[ERROR]");
            }
        }
        return Integer.parseInt(input);
    }

    private void validateInputBudget(String input) {
        int parseInput;

        try {
            parseInput = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

        if (parseInput % 1000 != 0 || parseInput < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto inputWinningNumbers() {
        String input;
        Lotto result;

        while (true) {
            try {
                input = Console.readLine();
                validateInputWinningNumbers(input);
                result = new Lotto(parseToNumbers(input));
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[ERROR]");
            }
        }

        return result;
    }

    private void validateInputWinningNumbers(String input) {
        try {
            parseToNumbers(input);
        } catch (PatternSyntaxException patternSyntaxException) {
            throw new IllegalArgumentException();
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> parseToNumbers(String input) {
        String[] splitInput;
        List<Integer> numbers = new ArrayList<>();

        splitInput = input.split(",");
        for (String number : splitInput) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public int inputBonusWinningNumber(Lotto winningNumbers) {
        String input;

        while (true) {
            try {
                input = Console.readLine();
                validateInputBonusWinningNumber(input, winningNumbers);
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println("[ERROR]");
            }
        }
        return Integer.parseInt(input);
    }

    private void validateInputBonusWinningNumber(String input, Lotto winningNumbers) {
        int parseInput;
        List<Integer> numbers = winningNumbers.getNumbers();

        try {
            parseInput = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

        if (parseInput < 1 || parseInput > 45 || numbers.contains(parseInput)) {
            throw new IllegalArgumentException();
        }
    }

}
