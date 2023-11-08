package lotto.domain;

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

    public void printLotto() {
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
    }
}

/*
*
- 접근 제어자(private) 변경 불가
- 필드(인스턴스 변수)를 추가 X
- 패키지 변경 가능
* */