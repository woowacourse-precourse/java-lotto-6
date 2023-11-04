package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validateNumberRange(numbers);
        return numbers;
    }

    public void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(this::validateSingleNumberRange);
    }

    private void validateSingleNumberRange(Integer number) {
        if (number < Lotto.MIN_LOTTE_NUMBER || number > Lotto.MAX_LOTTE_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이로 발급되어야 합니다.");
        }
    }
}
