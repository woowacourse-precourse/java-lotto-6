package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> compareNumbers = new HashSet<>(numbers);
        if(compareNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

}
