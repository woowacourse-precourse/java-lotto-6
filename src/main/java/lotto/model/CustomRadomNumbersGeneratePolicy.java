package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;

public class CustomRadomNumbersGeneratePolicy {
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() != LottoConstant.SIZE) {
            final Integer newNumber = pickRandomNumber();
            updateNumbers(numbers, newNumber);
        }
        return numbers;
    }

    private void updateNumbers(List<Integer> numbers, final Integer newNumber) {
        if (!numbers.contains(newNumber)) {
            numbers.add(newNumber);
        }
    }

    private Integer pickRandomNumber() {
        return Randoms.pickNumberInRange(
                LottoConstant.MIN_NUMBER,
                LottoConstant.MAX_NUMBER
        );
    }
}
