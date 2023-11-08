package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        eachNumberValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void eachNumberValidate(List<Integer> numbers){
        for(int i=0; i<5; i++){
            for(int j=i+1; j<6; j++){
                compare(numbers, i, j);
            }
        }
    }

    private void compare(List<Integer> numbers, int i, int j){
        if(numbers.get(i).equals(numbers.get(j))){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }
}
