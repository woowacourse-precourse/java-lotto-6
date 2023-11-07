package lotto;

import java.util.*;

public class Lotto {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchNumbers(Lotto other) {
        int count = 0;
        for (int number : numbers) {
            if (other.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

}