package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSameNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 숫자 6개를 입력해야 합니다.");
        }
    }

    private void checkSameNumber(List<Integer> numbers){
        boolean hasSameNumber =false;

        hasSameNumber = numbers.size() != numbers.stream().distinct().count();
        if (hasSameNumber) {
            throw new IllegalArgumentException("당첨 번호는 중복된 숫자가 없어야 합니다.");
        }
    }
    // TODO: 추가 기능 구현
}
