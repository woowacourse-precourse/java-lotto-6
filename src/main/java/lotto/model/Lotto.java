package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복값이 있습니다.");
        }
    }

    public static List<Integer> makeLottoNumbers() {
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static List<Integer> getNumbers() {
        return numbers;
    }

}
