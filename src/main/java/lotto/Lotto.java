package lotto;

import java.awt.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers == null) {
            throw new IllegalArgumentException("로또 번호는 6개이여야 합니다.");
        }
        if(duplicationCheck(numbers)){
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
        if(!rangeCheck(numbers)){
            throw new IllegalArgumentException("1~45 범위를 넘어간 값이 있습니다.");
        }
    }

    private boolean duplicationCheck(List<Integer> numbers){
        HashSet<Integer> checkNumber = new HashSet<>();
        for(int check : numbers){
            if(!checkNumber.add(check)){
                return true;
            }
        }
        return false;
    }

    private boolean rangeCheck(List<Integer> numbers){
        for(int rangeNumber : numbers){
            if(rangeNumber < 1 || rangeNumber > 45){
                return false;
            }
        }
        return true;
    }

    // TODO: 추가 기능 구현
}
