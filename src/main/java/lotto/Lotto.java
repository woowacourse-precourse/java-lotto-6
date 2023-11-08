package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //로또 번호의 범위 판단
        for (int number:numbers){
            if(number<1 ||number>45){
                throw new IllegalArgumentException();
            }
        }
        //로또 번호 중복 판단
        Set<Integer> uniquenumbers=new HashSet<>(numbers);
        if(uniquenumbers.size()!= numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
