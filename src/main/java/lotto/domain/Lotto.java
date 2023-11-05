package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
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

    public List<List<Integer>> getMatchedNumber(List<List<Integer>> randomNumbers, int bonusNumber) {
        List<List<Integer>> matchedNumber = new ArrayList<>();
        for (List<Integer> randomNumber : randomNumbers) {
            matchedNumber.add(countMatchedNumber(randomNumber, bonusNumber));
        }
        return matchedNumber;
    }

    private List<Integer> countMatchedNumber(List<Integer> randomNumber, int bonusNumber) {
        List<Integer> matchedNumber = new ArrayList<>();
        int count = 0;
        int bonus = 0;
        for (int number : numbers) {
            if (randomNumber.contains(number)) {
                count++;
            }
            if (randomNumber.contains(bonusNumber)){
                bonus++;
            }
        }
        matchedNumber.add(count);
        matchedNumber.add(bonus);
        return matchedNumber;
    }
}
