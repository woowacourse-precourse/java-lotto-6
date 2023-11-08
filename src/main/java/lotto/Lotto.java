package lotto;

import lotto.message.ErrorMessage;

import java.util.ArrayList;
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
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_6NUMBERS.toString());
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.addAll(numbers);
        if (numbers.size()!= uniqueNumbers.size()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE.toString());
        }
        for(Integer num : numbers){
            if(num<1 | num>45){
                throw new IllegalArgumentException(ErrorMessage.ERROR_OUT_RANGE.toString());
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public Lotto copy(){
        List<Integer> newNumbers=new ArrayList<>();
        for(Integer num:numbers){
            newNumbers.add(num);
        }
        return new Lotto(newNumbers);
    }
}
