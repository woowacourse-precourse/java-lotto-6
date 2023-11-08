package lotto.model;

import static lotto.constant.CommonUnits.MAX_LOTTO_NUMBER;
import static lotto.constant.CommonUnits.MIN_LOTTO_NUMBER;
import static lotto.constant.CommonUnits.NUMBERS_OF_LOTTO;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        isDup(numbers);
        numbers.stream().forEach(this::validateLottoNumber);
    }

    private void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER +
                "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 합니다.");
        }
    }

    private List<Integer> isDup(List<Integer> numbers) {
        if (numbers.stream().collect(Collectors.toSet()).size() != NUMBERS_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 올바른 갯수의 숫자를 입력해주세요.");
        }
        return numbers;
    }
}
