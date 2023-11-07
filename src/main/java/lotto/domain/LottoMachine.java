package lotto.domain;

import lotto.util.RandomLottoGenerator;

import java.util.List;

public class LottoMachine {

    public static List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = RandomLottoGenerator.getNumbers();
        validate(randomNumbers);
        return randomNumbers;
    }
    private static void validate(List<Integer> randomNumbers) {
        boolean duplicated = randomNumbers.stream().distinct().count() != randomNumbers.size();
        if(duplicated) {
            getRandomNumbers();
        }
    }

}
