package lotto.io;

import java.util.HashMap;
import java.util.List;

public class IOOperation {
    private static final Integer UNIT = 1000;

    public static Boolean isPriceCorrect(Integer price) {
        if (price % UNIT != 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static Boolean isWinningNumberNotDuplicated(List<Integer> winningNumbers) {
        HashMap<Integer, Boolean> duplication = new HashMap<>();

        for (Integer winningNumber : winningNumbers) {
            if (duplication.containsKey(winningNumber)) {
                throw new IllegalArgumentException();
            }

            duplication.put(winningNumber, true);
        }

        return true;
    }

    public static Integer numberOfLotto(Integer price) {
        return price / UNIT;
    }
}
