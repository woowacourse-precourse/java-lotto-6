package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int NUMBER_OF_LOTTO = 6;
    private final List<LottoNumber> numbers;

    public Lotto() {
        this.numbers = createLotto();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<LottoNumber> createLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        while (numbers.size() < NUMBER_OF_LOTTO) {
            LottoNumber lottoNumber = new LottoNumber();
            if (!numbers.contains(lottoNumber)) {
                numbers.add(lottoNumber);
            }
        }
        return lottoNumbers;
    }

}
