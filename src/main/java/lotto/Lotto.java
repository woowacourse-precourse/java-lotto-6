package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        lottoInRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return this.numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개입니다");
        }
    }

    private void checkOverlap(List<Integer> numbers){
        int k = 0;
        for(int i = k+1; i < numbers.size(); i++){
            if(numbers.get(k) == numbers.get(i)) throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
            k++;
        }
    }

    private void lottoInRange(List<Integer> numbers){
        for(int i = 0; i < numbers.size(); i++){
            int num = numbers.get(i);
            if(num < 1 || num > 45) throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
