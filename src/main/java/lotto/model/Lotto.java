package lotto.model;

import java.util.List;

import static lotto.model.Constants.LOTTO_LENGTH;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int countMatchEachLotto(List<Integer> eachLotto) {
        int match = 0;

        for (int i=0;i<LOTTO_LENGTH;i++) {
            if (eachLotto.contains(numbers.get(i))) {
                match++;
            }
        }

        return match;
    }

    public boolean checkLottoContainBonus(int bonus) {
        return numbers.contains(bonus);
    }

}
