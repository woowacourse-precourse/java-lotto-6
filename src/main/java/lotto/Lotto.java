package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = upperSort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> upperSort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public int compareLottoToWinnerNumbers(List<Integer> winnerNumbers) {
        int result = 0;

        for (int winnerNumber : winnerNumbers) {
            if (hasNumber(winnerNumber)) {
                result++;
            }
        }

        return result;
    }

    private boolean hasNumber(int number) {
        if (numbers.contains(number)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
// TODO: 추가 기능 구현
}
