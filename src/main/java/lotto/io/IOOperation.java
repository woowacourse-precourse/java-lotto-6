package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Lotto;

import java.util.HashMap;
import java.util.List;

public class IOOperation {
    private static final Integer UNIT = 1000;
    private static final Integer MINIMUM_RANGE = 1;
    private static final Integer MAXIMUM_RANGE = 45;

    public static void priceCorrect(Integer price) {
        if (price % UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void winningNotDuplicated(List<Integer> winningNumbers) {
        HashMap<Integer, Boolean> duplication = new HashMap<>();

        for (Integer winningNumber : winningNumbers) {
            if (duplication.containsKey(winningNumber)) {
                throw new IllegalArgumentException();
            }

            duplication.put(winningNumber, true);
        }
    }

    public static Integer numberOfLotto(Integer price) {
        return price / UNIT;
    }

    public static Boolean inRange(Integer number) {
        if (MINIMUM_RANGE <= number && number <= MAXIMUM_RANGE) {
            return true;
        }

        return false;
    }

    public static void numbersInRange(List<Integer> winningNumbers, Integer bonusNumber) {
        for (Integer winningNumber : winningNumbers) {
            if (!inRange(winningNumber)) {
                throw new IllegalArgumentException();
            }
        }

        if (!inRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
