package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }
        else if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 중 중복이 있습니다.");
        }
    }

    public static Lotto generate() {
        List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
