package lotto;

import lotto.controller.LottoErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkDuplication(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        validate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // 로또 내용 출력
    public void printLotto() {
        System.out.println(this.numbers);
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    public void checkDuplication(List<Integer> numbers) {
        for (int number : numbers) {
            if(Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException(
                        LottoErrorMessage.INVALID_LOTTO_NUMBER_DUPLICATION.getMessage());
            }
        }
    }
}
