package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void checkAnswerNumber(String[] split) throws IllegalArgumentException {
        int num;
        if (split.length != 6) throw new IllegalArgumentException();
        for (int i = 0; i < split.length; i++) {
            try {
                num = Integer.parseInt(split[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            if (num < 0 || num > 45) throw new IllegalArgumentException();
        }
    }

    public static void checkDuplication(List<Integer> checklist) throws IllegalArgumentException {
        Set<Integer> checkset = new HashSet<>(checklist);
        if (checkset.size() != checklist.size()) throw new IllegalArgumentException();
    }

    public static void checkBonusNumber(String input) {
        int bonus;
        try {
            bonus = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (bonus < 0 || bonus > 45) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkPrice(String input) throws IllegalArgumentException {
        int price;
        try {
            price = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (price % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
