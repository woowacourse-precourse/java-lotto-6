package lotto.domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Duplicatedvalidate(numbers);
        RangeValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void Duplicatedvalidate(List<Integer> numbers) {
        int count=0;
        for(int i=0; i<6; i++){
            count += Collections.frequency(numbers, numbers.get(i));
        }
        if(count > 6) {
            throw new IllegalArgumentException();
        }
    }

    public void RangeValidate(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++){
            if(1>numbers.get(i)||numbers.get(i)>45){
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    public void printLotto(){
        System.out.println(numbers);
    }
}
