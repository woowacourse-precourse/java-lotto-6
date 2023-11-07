package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public int countMatching(Lotto winningLotto) {
        // TODO: 일치하는 번호 개수 반환
        return 0;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호가 유효하지 않습니다.");
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
