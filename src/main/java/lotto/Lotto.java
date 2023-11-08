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

    void printNumbers() {
        System.out.println(numbers);
    }

    Prize compare(LuckyNumber luckyNumber) {
        int matches = 0;
        boolean bonus = false;

        for (int lottoNumber : this.numbers) {
            if (luckyNumber.has(lottoNumber)) {
                matches++;
            }
        }
        if (luckyNumber.bonusIs(this.numbers)) {
            bonus = true;
        }
        return new Prize(matches, bonus);
    }


}
