package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATED_LOTTO;
import static lotto.constant.ErrorMessage.INCORRECT_NUMBER_OF_LOTTO;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
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
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBER_OF_LOTTO);
        return lottoNumbers.stream().map(LottoNumber::new).toList();
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
