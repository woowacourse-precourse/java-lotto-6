package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        findSameNum(numbers);
        this.numbers = upperSort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void findSameNum(List<Integer> numbers) {
        for (int num : numbers) {
            int test = numbers.stream().filter(i -> i == num).toList().size();
            if (test >= 2) {
                throw new IllegalArgumentException();
            }
        }
    }

    private List<Integer> upperSort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public int compareLottoToWinnerNumbers(List<Integer> winnerNumbers, int bonusNumber) {
        int result = 0;

        for (int winnerNumber : winnerNumbers) {
            if (hasNumber(winnerNumber)) {
                result++;
            }
        }

        if (result == 5) {
            if (hasNumber(bonusNumber)) {
                return 999;
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
