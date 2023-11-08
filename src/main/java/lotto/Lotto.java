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
        boolean isSizeInvalid = numbers.size() != 6;
        boolean isThereAnyDuplicatedNumber
                = numbers.size() != numbers.stream().distinct().count();
        boolean isThereAnyOutrangedNumber = false;
        for (Integer number : numbers) {
            if (number < 1 || 45 < number) {
                isThereAnyOutrangedNumber = true;
            }
        }

        if (isSizeInvalid || isThereAnyDuplicatedNumber || isThereAnyOutrangedNumber) {
            throw new IllegalArgumentException(
                    "로또 번호는 1이상 45 이하의 중복되지 않는 6개의 정수여야 합니다.");
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
