package lotto.exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidInput {

    private final String ERROR = "[ERROR]";

    public void DuplicateNumberException(String[] inputNumbers) {
        List<String> verifiedNumber = new ArrayList<>();

        for (String number : inputNumbers) {
            if (verifiedNumber.contains(number)) {
                throw new IllegalArgumentException(ERROR + " 로또 번호는 중복 되지 않는 6개의 숫자 여야 합니다.");
            }
            verifiedNumber.contains(number);
        }
    }
}
