package lotto;

import camp.nextstep.edu.missionutils.Console;

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


    
}
