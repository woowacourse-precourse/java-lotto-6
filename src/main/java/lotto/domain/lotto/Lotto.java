package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
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

    // TODO: 추가 기능 구현

    /**
     * 로또를 오른 차순으로 정리
     */
    public List<Integer> organizeLotto() {
        List<Integer> organizeLotto = new ArrayList<>(this.numbers);

        Collections.sort(organizeLotto);

        return organizeLotto;
    }

}
