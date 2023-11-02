package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.NumberConstant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NumberConstant.LOTTO_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    public int getRightCount(List<Integer> lottoNumbers){
        int combineSize = getNumbersAddLotto(lottoNumbers).size();
        return NumberConstant.DOUBLE_LOTTO_RANGE - combineSize;
    }

    private Set<Integer> getNumbersAddLotto(List<Integer> lottoNumbers){
        Set<Integer> sNumbers = new HashSet<>(numbers);
        sNumbers.addAll(lottoNumbers);
        return sNumbers;
    }
}
