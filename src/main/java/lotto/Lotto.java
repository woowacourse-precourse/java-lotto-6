package lotto;

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

    public int checkLottoWinning(List<Integer> chosenNums) {
        int winningNumber = 0;

        for (int i = 0; i < chosenNums.size(); i++) {
            if (chosenNums.get(i) == numbers.get(i)) {
                winningNumber++;
            }
        }

        return winningNumber;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
