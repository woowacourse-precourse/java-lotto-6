package lotto;

import java.util.Collections;
import java.util.List;
import lotto.validate.Validate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validate validate = new Validate();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        // 1 ~ 45 사이의 숫자인지 검증
        for(int number: numbers){
            validate.validateNumberInRange(number, 1, 45);
        }

        // 중복된 값이 있는지 검증
        validate.validateDuplicatedOfList(numbers);
    }

    // TODO: 추가 기능 구현
    public void print() {
        System.out.println(numbers.toString());
    }

    // 입력한 숫자가 로또에 들어 있는지 확인
    public boolean numberInLotto(int number) {
        if (numbers.contains(number)) {
            return true;
        }
        return false;
    }

    // 당첨 번호와 일치하는 갯수 반환
    public int calculateCorrectCount(Lotto winningNumbers) {
        int count = 0;

        for (int number: numbers) {
            if (winningNumbers.numberInLotto(number)) {
                count++;
            }
        }

        return count;
    }
}
