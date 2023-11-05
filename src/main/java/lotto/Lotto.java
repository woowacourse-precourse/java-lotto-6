package lotto;

import java.util.HashSet;
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
    }

    private void checkDuplicationNumber(List<Integer> numbers){
        HashSet<Integer> duplicationNumber = new HashSet<>(numbers);
        if(duplicationNumber.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하셨습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
