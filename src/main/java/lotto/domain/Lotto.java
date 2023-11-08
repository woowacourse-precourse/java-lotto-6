package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>();
        for (Integer number : numbers) {
            this.numbers.add(number);
        }
        this.numbers.sort(null);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException();
            if (Collections.frequency(numbers, number) > 1)
                throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    /*
     * @author 강병관
     *
     * 로또를 당첨 번호와 비교하는 함수.
     */
    public LottoEnum getRanking(List<Integer> winNumbers, Integer bonusNumber) {
        int count = 0;
        for (Integer num : numbers) {
            if (winNumbers.contains(num))
                count++;
        }
        boolean isBonus = numbers.contains(bonusNumber);
        LottoEnum ranking = LottoEnum.valueOf(count, isBonus);
        return ranking;
    }

    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
