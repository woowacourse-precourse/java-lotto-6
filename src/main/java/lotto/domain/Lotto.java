package lotto.domain;

import java.util.Collections;
import java.util.List;

/**
 * 로또 게임에서 사용되는 로또 번호들의 집합을 나타내는 클래스.
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        // TODO: 번호 반환 메소드 구현
        return Collections.unmodifiableList(numbers);
    }

    public int matchCount(List<Integer> winningNumbers) {
        // TODO: 당첨 번호와 일치하는 번호 개수 확인 로직 구현
        return 0;
    }

    private void sortNumbers() {
        Collections.sort(numbers);
    }
}
