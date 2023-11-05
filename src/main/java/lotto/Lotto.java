package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortOfLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        LottoNumbersValidator.Validator(numbers);
    }

    // 로또 오름차순 정렬
    private static List<Integer> sortOfLotto(List<Integer> numbers) {
        List<Integer> result = new ArrayList<Integer>(numbers);
        Collections.sort(result);
        return result;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
