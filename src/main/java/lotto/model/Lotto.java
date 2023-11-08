package lotto.model;

import lotto.common.Constant;
import lotto.common.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        validateScope(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> districtNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if(districtNumbers.size() != numbers.size()) throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION);
    }

    private void validateScope(List<Integer> numbers){
        for(int n : numbers){
            if(n > Constant.LOTTO_MAX || n < Constant.LOTTO_MIN)
                throw new IllegalArgumentException(ErrorMessage.LOTTO_SCOPE);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(numbers);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
