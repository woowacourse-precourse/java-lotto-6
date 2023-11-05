package lotto.domain;

import java.util.ArrayList;
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

    private boolean isInteger() {
        return true;
    }

    private void checkInteger() {

    }

    private boolean isInRange() {
        return true;
    }

    private void checkRange() {

    }

    private boolean isDuplicateWinningNumbers(){
        return true;
    }

    public int matchSameNumberNum(Lotto lotto) {
        int sameNumberNum = (int) numbers.stream()
                .filter(number -> lotto.hasSameNumber(number))
                .count();

        return sameNumberNum;
    }

    public boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }
}
