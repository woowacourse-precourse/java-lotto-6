package lotto;

import java.util.List;

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
        //리스트 내의 중복된 요소 확인
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

    int getNumber(int index){
        return numbers.get(index);
    }
}
