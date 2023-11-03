package lotto.exception;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

public class InvalidInput {

    private final static String ERROR = "[ERROR]";
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    public void duplicateNumberException(String[] inputNumbers) {
        List<String> verifiedNumber = new ArrayList<>();

        for (String number : inputNumbers) {
            if (verifiedNumber.contains(number)) {
                throw new IllegalArgumentException(ERROR + " 로또 번호는 중복 되지 않는 6개의 숫자 여야 합니다.");
            }
            verifiedNumber.contains(number);
        }
    }

    public void outOfRangeException(int inputNumber) {
        if (inputNumber < MIN_NUMBER || inputNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR + "로또 번호의 숫자 범위는 1~45 까지이다.");

        }
    }
}
