package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.global.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.model.LottoInfo.NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }
    private void validNumbers(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size()!=NUMBER_COUNT)
            throw new IllegalArgumentException(DUPLICATE_NUMBER.toString());
    }

    public int match(List<Integer> goal, Integer bonus){
        int count = (int) numbers.stream().filter(goal::contains).count();
        if(numbers.contains(bonus))
            return rank(count,true);
        return rank(count,false);
    }
    private int rank(int count,boolean bonus){
        switch (count){
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
                if(bonus)
                    return 2;
                return 3;
            case 6:
                return 1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return numbers.toString();
    }
}
