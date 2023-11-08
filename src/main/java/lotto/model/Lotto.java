package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    int winningCount = 0;
    boolean winningBounsNumber = false;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public int getWinningCount(){
        return this.winningCount;
    }

    public boolean getWinningBounsNumber(){
        return this.winningBounsNumber;
    }

    private void validate(List<Integer> numbers) {
        chekckLottoSize(numbers);
        checkNumbersUnique(numbers);
    }

    private void chekckLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersUnique(List<Integer> numbers) {
        int distinctNumbersSize = calculateDistinctNumberSize(numbers);
        if (distinctNumbersSize != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateDistinctNumberSize(List<Integer> numbers) {
        List<Integer> distinctRandomNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctRandomNumbers.size();
    }
}
