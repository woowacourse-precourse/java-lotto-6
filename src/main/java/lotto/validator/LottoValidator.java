package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LottoValidator {
    private boolean isNotSizeSix(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    public void checkSize(List<Integer> numbers) {
        if (isNotSizeSix(numbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 6개만 입력하세요.");
        }
    }
}
