package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import validation.IntegerValidator;
import validation.ListValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Const.LOTTO_BEGIN, Const.LOTTO_END, Const.LOTTO_NUMBERS);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Const.LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] : 입력 숫자는 " + Const.LOTTO_NUMBERS + "개여야 합니다.");
        }

        for(int number : numbers) {
            IntegerValidator.checkRange(number, Const.LOTTO_BEGIN, Const.LOTTO_END);
        }

        ListValidator.checkDuplicate(numbers);
    }

    // TODO: 추가 기능 구현
}
