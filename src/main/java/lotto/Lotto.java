package lotto;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private static final int LOTTO_SIZE=6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        if (isDuplicated(numbers)){
            throw new IllegalArgumentException();
        }
        Validator validator=Validator.INSTANCE;
        validator.validateOutOfRange(numbers);
    }

    private boolean isDuplicated(List<Integer> numbers){
        int uniqueSize=numbers.stream().distinct().toList().size();

        return uniqueSize!=LOTTO_SIZE;
    }

    public List<Integer> getSortingNumbers(){
        return numbers.stream().sorted().toList();
    }

    public boolean isContains(int number){
        return numbers.contains(number);
    }
}
