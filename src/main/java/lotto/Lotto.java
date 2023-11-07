package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
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

    Integer compare(HashSet<Integer> luckyNumbers, Integer bonusNumber) {
        List<Integer> lottoNumbers = this.numbers;
        int count = 0;
        for (int lottoNumber : lottoNumbers) {
            for (int luckynumber : luckyNumbers) {
                if (lottoNumber == luckynumber) {
                    count++;
                }
            }
        }
        if (count == 5 & lottoNumbers.contains(bonusNumber)) {
            System.out.println("2!!!");
        }
        return count;
    }


}
