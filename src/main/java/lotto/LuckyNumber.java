package lotto;

import java.util.HashSet;
import java.util.List;

public class LuckyNumber {
    private HashSet<Integer> numbers;
    private Integer bonusNumber;

    public LuckyNumber() {
        this.bonusNumber = null;
        this.numbers = new HashSet<>();
    }

    void getNumbers(List<Integer> input) {
        this.numbers = new HashSet<>(input);
        Validator.isSizeInRange(this.numbers);

    }

    void getBonusNumber(String input) {
        int number = Change.stringToInt(input);

        Validator.isInRange(number);
        Validator.isAlreadyExist(this.numbers, number);

        this.bonusNumber = number;
    }

    boolean has(int numberToCompare) {
        return this.numbers.contains(numberToCompare);
    }

    boolean bonusIs(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(this.bonusNumber);
    }


}
