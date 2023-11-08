package validator;

import lotto.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private final static int MIN_LOTTO =1;
    private final static int MAXLOTTO=45;
    private final static int UNIT=1000;
    public static void checkAnswerNumber(String[] split) throws IllegalArgumentException {
        int num;
        if (split.length != 6) throw new IllegalArgumentException();
        for (int i = 0; i < split.length; i++) {
            try {
                num = Integer.parseInt(split[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            if (num < MIN_LOTTO || num > MAXLOTTO) throw new IllegalArgumentException();
        }
    }

    public static void checkDuplication(List<Integer> checklist) throws IllegalArgumentException {
        Set<Integer> checkset = new HashSet<>(checklist);
        if (checkset.size() != checklist.size()) throw new IllegalArgumentException();
    }

    public static void checkBonusNumber(String input, Lotto answer) {
        int bonus;
        try {
            bonus = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (bonus < MIN_LOTTO || bonus > MAXLOTTO) {
            throw new IllegalArgumentException();
        }
        List<Integer> answerList = answer.getNumbers();
        if (answerList.contains(bonus)) {
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
        if (price % UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
}
