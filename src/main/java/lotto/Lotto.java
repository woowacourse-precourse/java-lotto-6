package lotto;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO;
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
        validateLottoDuplicated(numbers);
        this.numbers = numbers.stream().map(LottoNumber::new).toList();
    }

    private void validateLottoDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO);
        }
    }

    private void validateNumberOfLotto(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_OF_LOTTO);
        }
    }

    private List<LottoNumber> createLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() < NUMBER_OF_LOTTO) {
            LottoNumber lottoNumber = new LottoNumber();
            if (!lottoNumbers.contains(lottoNumber)) {
                lottoNumbers.add(lottoNumber);
            }
        }
        return lottoNumbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public int countMatchNumbers(Lotto userLotto) {
        return (int) numbers.stream().filter(userLotto::contains).count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }
}
