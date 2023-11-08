package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        equalNumberValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void equalNumberValidate(List<Integer> numbers){ // 동일한 숫자가 존재하면 예외 발생한다
        HashSet<Integer> numberHashSet = new HashSet<>(); // Set선언
        for(int number : numbers){
            numberHashSet.add(number);
        }
        if(numberHashSet.size() != 6){ // Set의 size가 6이 아니면 동일한 숫자가 있다는 것이므로 예외 발생한다
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> LottoReturn(){
        return this.numbers;
    }
}
