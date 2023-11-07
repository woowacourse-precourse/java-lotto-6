package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate_Duplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void validate_Duplication(List<Integer> numbers){
        for(int index = 0; index < numbers.size(); index++){
            int number = numbers.get(index);
            inside_Validate_Duplication(number, numbers, index);
        }
    }

    private void inside_Validate_Duplication(int number, List<Integer> numbers, int index){
        for(int i=0; i<numbers.size(); i++){
            if(number == numbers.get(i) && i != index){
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
