package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    static private final int MIN_NUMBER = 1;
    static private final int MAX_NUMBER = 45;
    static private final int SIZE_NUMBER = 46;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        final boolean[] checkDuplicateNumber = new boolean[SIZE_NUMBER];
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 수여야 합니다.");
            }
            if (checkDuplicateNumber[number]) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 수여야 합니다.");
            }
            checkDuplicateNumber[number] = true;
        }
    }
}
