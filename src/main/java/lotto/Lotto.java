package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Lottery Ticket
 */
public class Lotto {
    private final List<Integer> numbers;

    /**
     * Lottery quick pick: Generate own numbers randomly
     */
    public Lotto() {
        List<Integer> quickPicked
                = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        validate(quickPicked);
        numbers = quickPicked;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return immutable number list sorted in ascending order
     */
    public List<Integer> getImmutableSortedNumbers() {
        List<Integer> copied = new ArrayList<>(numbers);
        Collections.sort(copied);
        return Collections.unmodifiableList(copied);
    }

    // TODO: 추가 기능 구현
}
