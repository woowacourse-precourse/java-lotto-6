package lotto.domain;

import lotto.view.Message;

import java.util.List;

import static lotto.view.Constants.*;

public class NumValidator {

    public static int checkNumber(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            Message.typeException();
            throw new IllegalArgumentException();
        }
    }

    public static int checkRange(int num) {
        if (num <= 0 || num > MAX_NUM) {
            Message.rangeException();
            throw new IllegalArgumentException();
        }
        return num;
    }

    public static void checkCntNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUM_OF_LOTTO) {
            Message.rangeException();
            throw new IllegalArgumentException();
        }
    }


}
