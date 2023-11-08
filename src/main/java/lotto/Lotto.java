package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 6자리 인지 검사
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 6개의 당첨 번호를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    // 당첨 번호 중 중복된 숫자가 있는지 확인


}
