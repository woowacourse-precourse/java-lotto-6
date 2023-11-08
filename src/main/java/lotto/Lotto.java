package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(sortNumbers(numbers));
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Comparator.naturalOrder());
        return sortedNumbers;
    }

    public void printLottoNumbers() {
        System.out.print("[");
        String result = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        System.out.println(result + "]");
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
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_COUNT_ERROR.getMessage());
        }
        if (numbers.size() > numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_DUPLICATE_ERROR.getMessage());
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45))
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE_ERROR.getMessage());
    }
}
