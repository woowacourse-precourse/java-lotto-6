package lotto;

import java.util.List;

public class Lotto {
    // 로또 숫자 리스트
    private final List<Integer> numbers;

    // 로또 리스트 생성
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 숫자가 6개가 맞는지 유효성 체크, 없으면 예외발생
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getter(){
        return numbers;
    }
}
