package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers, 1, 45);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> validate = new ArrayList<>();
        for(Integer number : numbers) {
            if(validate.contains(number)) {
                System.out.println("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
                throw new IllegalArgumentException();
            }
            validate.add(number);
        }
    }

    public static void validateRange(List<Integer> numbers, int startLottoNumber, int endLottoNumber) {
        for(Integer number : numbers) {
            if(number > endLottoNumber || number < startLottoNumber) {
                System.out.println("[ERROR] 로또 번호는 " + startLottoNumber + "부터 " + endLottoNumber + " 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
}
