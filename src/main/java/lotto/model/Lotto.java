package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbersCheck(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 갯수는 6개 입니다.");
        }
    }

    // TODO: 추가 기능 구현
    private void numbersCheck(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            overlap(numbers.get(i), numbers);
        }
    }

    private void overlap(int number, List<Integer> numbers){
        int count = 0;
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == number){
                count++;
            }
            if(count > 1){
                throw new IllegalArgumentException("[ERROR] 숫자는 모두 다른 숫자로 이루어져 있어야 합니다.");
            }
        }
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public boolean findNumber(int number){
        int result = numbers.indexOf(number);
        if(result == -1){
            return false;
        }
        return true;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

}
