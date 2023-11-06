package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.LottoNumber;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoNumber.COUNT.getValue()) {
            throw new IllegalArgumentException();
        }

        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers)
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자는 중복되지 않은 수여야 합니다.");
            }
    }

    // TODO: 추가 기능 구현
    // Lotto 생성
    public static List<Integer> generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoNumber.MIN.getValue(),
                LottoNumber.MAX.getValue(), LottoNumber.COUNT.getValue());
        Collections.sort(numbers);
        return numbers;
    }

    // 당첨 번호 확인
    public int countNumber(List<Integer> winNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (winNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    // 보너스 번호 포함 여부 확인
    public boolean containBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
