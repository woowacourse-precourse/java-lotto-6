package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> lottoNums;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNums = numbers;
    }

    public List<Integer> getLottoNums() {
        return lottoNums;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }

        for (int number : uniqueNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
