package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final String prefix = "[ERROR] ";
    static final int NUM_OF_LOTTONUM = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUM_OF_LOTTONUM) {
            throw new IllegalArgumentException(prefix + "숫자 6개를 입력해야 합니다.");
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                checkDuplicate(numbers, i, j);
            }
        }
    }

    private static void checkDuplicate(List<Integer> numbers, int i, int j) {
        if (numbers.get(i).equals(numbers.get(j))) {
            throw new IllegalArgumentException(prefix + "중복된 숫자가 있습니다.");
        }
    }

    public boolean containsNum(int num) {
        if (numbers.contains(num)) {
            return true;
        }
        return false;
    }
}
