package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumbersValidator;
import lotto.domain.LuckyNumbers;

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

    // 로또 일치 개수
    public int matchCount(LuckyNumbers luckyNumbers) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (luckyNumbers.getWinningNumbers().contains(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
