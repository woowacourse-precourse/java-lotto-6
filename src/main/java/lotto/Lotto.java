package lotto;

import static lotto.constant.ErrorMessage.INCORRECT_NUMBER_OF_LOTTO;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int NUMBER_OF_LOTTO = 6;

    private final List<LottoNumber> numbers;

    public Lotto() {
        this.numbers = createLotto();
    }

    public Lotto(List<Integer> numbers) {
        validateNumberOfLotto(numbers);
        this.numbers = numbers.stream().map(LottoNumber::new).toList();
    }

    private void validateNumberOfLotto(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_OF_LOTTO);
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
