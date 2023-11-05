package lotto.domain;

import java.util.List;
import java.util.StringJoiner;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.ErrorMessage;
import lotto.utils.LottoConstant;
import lotto.utils.LottoConstantValue;
import lotto.utils.Prize;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoConstantValue.LOTTO_NUMBERS_LENGTH.get()) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_LOTTO_NUMBERS_LENGTH.getFormattedMessage(
                            LottoConstantValue.LOTTO_NUMBERS_LENGTH.get()
                    )
            );
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        long uniqueNumbersLength = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != uniqueNumbersLength) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION.getMessage());
        }
    }

    public Prize getRank(Lotto winningLotto, LottoNumber bonusNumber) {
        int sameCount = getSameCount(winningLotto);
        boolean hasBonusNumber = doesHaveBonusNumber(bonusNumber);
        return Prize.getPrizeRank(sameCount, hasBonusNumber);
    }

    private int getSameCount(Lotto winningLotto) {
        // count는 long타입을 반환하지만 반환할 수 있는 최대 값은 6이므로 int로 형변환해도 값의 손실이 없다.
        return (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    private boolean doesHaveBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        StringJoiner lottoPrintFormat = new StringJoiner(
                LottoConstant.DELIMITER.getLottoStringWithSpace(),
                LottoConstant.OPENING_BRACKET.get(),
                LottoConstant.CLOSING_BRACKET.get());
        numbers.stream()
                .sorted()
                .map(LottoNumber::toString)
                .forEach(lottoPrintFormat::add);
        return lottoPrintFormat.toString();
    }
}
