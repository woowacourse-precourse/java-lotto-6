package lotto.domain;

import lotto.domain.constants.LottoRule;
import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> validNumbers = new ArrayList<>(numbers);
        Collections.sort(validNumbers);
        this.numbers = validNumbers;
    }

    private void validate(List<Integer> numbers) {
        lottoSizeValidate(numbers);
        lottoNumberRangeValidate(numbers);
        lottoDuplicateNumberValidate(numbers);
    }

    private void lottoSizeValidate(List<Integer> numbers) {
        if (numbers.size() != LottoRule.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.LOTTO_IS_NOT_SIZE.getValue()
                            , LottoRule.LOTTO_SIZE.getValue())
            );
        }
    }

    private void lottoNumberRangeValidate(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LottoRule.LOTTO_MIN_NUMBER.getValue()
                    || number > LottoRule.LOTTO_MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_OUT_OF_RANGE.getValue());
            }
        });
    }

    private void lottoDuplicateNumberValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LottoRule.LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE.getValue());
        }
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int matchCount(Lotto winningLotto) {
        return (int) this.numbers.stream().filter(winningLotto::contains).count();
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
