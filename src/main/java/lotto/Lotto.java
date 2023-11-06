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

    public Rank confirmRank(List<Integer> winningNumbers, int bonusNumber) {
        winningNumbers.retainAll(this.numbers);
        String winningNumberCount = String.valueOf(winningNumbers.size());

        Rank result = Rank.valueOfLabel(winningNumberCount);
        if(result == Rank.THIRD && this.numbers.contains(bonusNumber)) {
            result = Rank.SECOND;
        }
        return result;
    }
}
