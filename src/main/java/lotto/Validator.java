package lotto;

import java.util.HashSet;

public class Validator {
    static void isNotZero(int input) {
        if (input != 0) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    static void isInRange(int input) {
        if (input >= 1 & input <= 45) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    static void isMultipleOfThousand(int input) {
        if ((input % 1000) == 0) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    static void isAlreadyExist(HashSet<Integer> list, int input) {
        if (!list.contains(input)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    static void isSizeInRange(HashSet<Integer> list) {
        if (list.size() != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

}
