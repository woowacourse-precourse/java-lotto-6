package lotto.domain;

import lotto.util.RandomLottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private final List<Integer> randomNumbers;

    public LottoMachine() {
        this.randomNumbers = getRandomNumbers();
    }

    public List<Integer> getRandomNumbers() {
        List<Integer> randomNumber = sortRandomNumbers(RandomLottoGenerator.getNumbers());
        validate(randomNumber);
        return randomNumber;
    }

    public List<Integer> getNumbers() {
        return randomNumbers;
    }

    private void validate(List<Integer> randomNumbers) {
        boolean duplicated = randomNumbers.stream().distinct().count() != randomNumbers.size();
        if (duplicated) {
            getRandomNumbers();
        }
    }

    private List<Integer> sortRandomNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

}
