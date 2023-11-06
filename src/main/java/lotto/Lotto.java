package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.Constant.*;

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
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호는 " + NUMBER_COUNT + "개 정수입니다.");
        }
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(
                        ERROR_MESSAGE + "로또 번호는 " + MIN_NUMBER + "부터" + MAX_NUMBER + "까지의 정수여야 합니다."
                );
            }
        }
        HashSet<Integer> tempNumbers = new HashSet<>(numbers);
        if (tempNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호는 중복될 수 없습니다.");
        }
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}
