package lotto.lotto.model;

import static lotto.lotto.model.LottoConstant.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lotto.util.error.CustomError;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(CustomError.INPUT_MAX_NUMBER.getError());
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers){
        Map<Integer, Integer> map = new HashMap<>();
        for(int number : numbers){
            map.put(number, 1);
        }
        Set<Integer> keySet = map.keySet();
        if(keySet.size() != MAX_INPUT_NUMBER)
            throw new IllegalArgumentException(CustomError.NUMBER_DUPLICATE.getError());
    }
    public String toString(){
        return numbers.toString();
    }

    public int length(){
        return numbers.size();
    }

    public int get(int index){
        return numbers.get(index);
    }

    public List<Integer> getAll(){
        return this.numbers;
    }
}
