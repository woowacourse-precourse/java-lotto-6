package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    /**
     * 로또 번호를 관리하는 Domain
     * 초기 설정의 힌트는 검증을 생성자에서 이루는게 옳다는 것?
     */
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
