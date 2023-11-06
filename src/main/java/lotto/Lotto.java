package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        this.numbers = numbers;
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> overlapCheck = new HashSet<>();
        if(overlapCheck.size()!=6){
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void setRandomNumbers(){
        new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
    }
}
