package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicate(List<Integer>numbers){
        Set<Integer> checkDuplication = new HashSet<>(numbers);
        if(checkDuplication.size()!=6){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }


    // TODO: 추가 기능 구현
}
