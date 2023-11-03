package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

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

    public static Lotto generateRandomLottoNumbers() {
        List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        randomLottoNumbers.sort(Comparator.naturalOrder());
        return new Lotto(randomLottoNumbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
