package lotto.models;

import static lotto.utils.getCountOfMatch;

import java.util.Collections;
import java.util.stream.Collectors;
import lotto.configs.ComparisonScore;
import lotto.utils;
import java.util.List;
import lotto.configs.Constant;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constant.LOTTO_COUNT) {
            throw new IllegalArgumentException();
        }
        if (utils.hasDuplicates(numbers)) {
            throw new IllegalArgumentException();
        }
        if(utils.hasInvalidValue(numbers, Constant.LOTTO_MIN_NUMBER, Constant.LOTTO_MAX_NUMBER)){
            throw new IllegalArgumentException();
        }
    }

    public ComparisonScore getComparisonScore(Lotto lotto, int bonus){
        int countOfMatch = getCountOfMatch(this.numbers, lotto.numbers);
        boolean hasMatchBonus = false;
        if(this.numbers.contains(bonus)){
            countOfMatch++;
            hasMatchBonus = true;
        }
        return ComparisonScore.valueOf(countOfMatch, hasMatchBonus);
    }

    public boolean hasNumber(int number){
        return this.numbers.contains(number);
    }

    @Override
    public String toString() {
        return String.format(
                Constant.LOTTO_FORMAT,
                numbers.get(0), numbers.get(1), numbers.get(2),
                numbers.get(3), numbers.get(4), numbers.get(5)
        );
    }
}
