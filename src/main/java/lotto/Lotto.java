package lotto;

import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("복권의 숫자는 6개여야 합니다.");
        }
        if(numbers.size()!=new HashSet<Integer>(numbers).size()){
            throw new IllegalArgumentException("복권의 숫자는 중복되지 않아야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return this.numbers;
    }
    public void printNumbers(){
        System.out.println(getNumbers().toString());
    }
}
