package lotto.model;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    public static final int TICKET_PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        /* Check if List has six numbers */
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        /* Check if List has overlapping numbers */
        if (new HashSet<>(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public int numberOfWinningNumbers(WinningNumbers winningNumbers) {
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
