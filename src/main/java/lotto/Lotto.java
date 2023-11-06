package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        boolean[] checkBox = makeCheckBox();
        return (int)winningNumbers.stream()
                .filter(number -> checkBox[number])
                .count();
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    private boolean[] makeCheckBox() {
        boolean[] checkBox = new boolean[46];
        numbers.forEach(number -> checkBox[number] = true);
        return checkBox;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() > numbers.stream().distinct().count())
            throw new IllegalArgumentException();
    }
}
