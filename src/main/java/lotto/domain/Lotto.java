package lotto.domain;

import java.util.List;


public class Lotto { // 사용자에게 입력받은 6자리 숫자를 검증할 때 쓰이는 것으로 추정
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

    // TODO: 추가 기능 구현
}



