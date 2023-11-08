package lotto.Domain;

import lotto.InputData;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

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

    private void checkDuplicate(List<Integer> number){
        for(int i : number){
            if(Collections.frequency(number,i)>1){
                throw new IllegalArgumentException();
            }
        }
    }



    //로또 발행
    // TODO: 추가 기능 구현
}
