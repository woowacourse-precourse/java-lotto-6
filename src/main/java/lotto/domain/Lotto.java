package lotto.domain;

import static lotto.domain.LottoConstraint.MAX_LOTTO_NUM;
import static lotto.domain.LottoConstraint.MIN_LOTTO_NUM;
import static lotto.exception.LottoErrorMsg.DUPLICATED;
import static lotto.exception.LottoErrorMsg.OUT_OF_RANGE;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if(!isValidRange(numbers)){
            throw LottoException.triggeredBy(OUT_OF_RANGE);
        }
        if (isDuplicatedNum(numbers)){
            throw LottoException.triggeredBy(DUPLICATED);
        }

    }
    private boolean isDuplicatedNum(List<Integer> numbers){
        boolean[] isNumInNums = new boolean[MAX_LOTTO_NUM +1];
        Arrays.fill(isNumInNums,false);
        for (int num:numbers){
            if (isNumInNums[num]){
                return true;
            }
            isNumInNums[num] = true;
        }
        return false;
    }

    private boolean isValidRange(List<Integer> numbers){
        for (int num : numbers){
            if (num < MIN_LOTTO_NUM || num > MAX_LOTTO_NUM){
                return false;
            }
        }
        return true;
    }

}
