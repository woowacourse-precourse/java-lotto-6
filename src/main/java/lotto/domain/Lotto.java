package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

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
        Set<Integer> uniqueNumbers = new HashSet<Integer>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public Integer matchedLottoCount(List<Integer> lottoNumbers) {
        Integer match = 0;
        for (Integer lottoNumber: lottoNumbers) {
            if (numbers.contains(lottoNumber)) {
                match++;
            }
        }
        return match;
    }

    public Boolean didMatchBonus(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public String toString() {
        ArrayList<Integer> sortedNumbers = new ArrayList();
        for (Integer number : numbers) {
            sortedNumbers.add(number);
        }
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
