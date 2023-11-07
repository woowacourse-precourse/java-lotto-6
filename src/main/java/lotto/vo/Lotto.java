package lotto.vo;

import java.util.List;

import static lotto.values.ExceptionMessage.DUPLICATE_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void checkDuplication(List<Integer> numbers){
        for(int i=0; i<numbers.size(); i++){
            for(int j=i+1; j< numbers.size(); j++){
                if(numbers.get(i) == numbers.get(j)) {
                    throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
                }
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
