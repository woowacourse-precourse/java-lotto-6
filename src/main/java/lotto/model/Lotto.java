package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberUnique(numbers);
        this.numbers = sortImmutableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberUnique(List<Integer> numbers) {
        List<Integer> distinctList = numbers.stream().distinct().toList();

        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Rank compare(PlayerNumber player) {
        int match = compareWinningNumber(player.getWinningNumber());
        boolean bonus = compareBonusNumber(player.getBonusNumber());

        return Rank.match(match, bonus);
    }

    private int compareWinningNumber(List<Integer> winning) {
        int count = 0;

        for (int number : winning) {
            if (numbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean compareBonusNumber(int bonus) {
        return numbers.contains(bonus);
    }

    private List<Integer> sortImmutableList(List<Integer> numbers) {
        List<Integer> mutable = new ArrayList<>(numbers);
        Collections.sort(mutable);
        return Collections.unmodifiableList(mutable);
    }
    // TODO: 추가 기능 구현
}
