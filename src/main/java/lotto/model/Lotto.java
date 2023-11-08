package lotto.model;

import static lotto.common.exception.LottoErrorMessage.DUPLICATE_LOTTO_NUMBERS;
import static lotto.common.exception.LottoErrorMessage.INVALID_LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import lotto.common.exception.LottoException;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    private Lotto(final List<LottoNumber> lottoNumbers) {
        validateNumbers(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public static Lotto generateGandomLotto() {
        List<LottoNumber> lottoNumbers = LottoNumber.generateLottoNumbers(LOTTO_SIZE);
        return new Lotto(lottoNumbers);
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::generateLottoNumber)
                .toList();
        return new Lotto(lottoNumbers);
    }

    public void compare(Consumer<LottoNumber> biConsumer){
        for (LottoNumber number : numbers) {
            biConsumer.accept(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }

    private void validateNumbers(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }
    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoException(INVALID_LOTTO_SIZE);
        }
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if(numbers.size() != uniqueNumbers.size()) {
            throw new LottoException(DUPLICATE_LOTTO_NUMBERS);
        }
    }
}
