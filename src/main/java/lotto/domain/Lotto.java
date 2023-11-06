package lotto.domain;

import static java.util.Collections.sort;
import static lotto.utils.ErrorMessage.IS_INVALID_LOTTO_SIZE;

import java.util.List;

public class Lotto extends LottoNumber {
    private List<Integer> numbers;

    public Lotto(int lottoNumber) {
        super(lottoNumber);
    }
    public Lotto(List<Integer> numbers) {
        super();
        numbers.forEach(Lotto::new);
        sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isLottoSizeValid(numbers,LOTTO_SIZE);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
