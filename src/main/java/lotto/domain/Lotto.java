package lotto.domain;

import static lotto.domain.constants.LottoConstatants.LOTTO_MAX_NUMBER;
import static lotto.domain.constants.LottoConstatants.LOTTO_MIN_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개만 가능합니다.");
        }
    }
    private void validateDuplicated(List<Integer> numbers){
        Set<Integer> lotto = new HashSet<>(numbers);
        if(lotto.size() != 6)
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
    }

    private void validateRange(List<Integer>numbers){
        for(Integer i : numbers)
            if(i < LOTTO_MIN_NUMBER.getValue() || i > LOTTO_MAX_NUMBER.getValue())
                throw new IllegalArgumentException("[ERROR] 로또 숫자 범위는 1 ~ 45 입니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
