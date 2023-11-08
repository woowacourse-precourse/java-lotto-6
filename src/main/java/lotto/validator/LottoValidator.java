package lotto.validator;

import static lotto.constant.MessageConstants.CANNOT_DUPLICATE_LOTTO;
import static lotto.constant.MessageConstants.CANNOT_DUPLICATE_LOTTO_AND_BONUS;
import static lotto.constant.MessageConstants.LOTTO_COUNT;
import static lotto.constant.MessageConstants.LOTTO_NUMBER_RANGE;
import static lotto.constant.NumberConstants.LOTTO_NUMBER_MAX;
import static lotto.constant.NumberConstants.LOTTO_NUMBER_MIN;
import static lotto.constant.NumberConstants.LOTTO_NUMBER_SIZE;

import java.util.List;

public class LottoValidator {

    private final List<Integer> lottoList;

    public LottoValidator(List<Integer> lottoList) {
        this.lottoList = lottoList;
    }

    public void validateAll() {
        validateSize();
        validateNumberRange();
        validateUnique();
    }

    private void validateSize() {
        if (lottoList.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(LOTTO_COUNT);
        }
    }

    private void validateUnique() {
        if (hasDuplicateNumber()) {
            throw new IllegalArgumentException(CANNOT_DUPLICATE_LOTTO);
        }
    }

    private boolean hasDuplicateNumber() {
        return lottoList.stream()
                .distinct()
                .count() != LOTTO_NUMBER_SIZE;
    }

    private void validateNumberRange() {
        lottoList.stream()
                .filter(this::isNumberWrongRange)
                .forEach(number -> {
                    throw new IllegalArgumentException(LOTTO_NUMBER_RANGE);
                });
    }

    public void validateBonusNumber(int bonusNumber) {
        if (isNumberWrongRange(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE);
        }

        if (lottoList.contains(bonusNumber)) {
            throw new IllegalArgumentException(CANNOT_DUPLICATE_LOTTO_AND_BONUS);
        }
    }

    private boolean isNumberWrongRange(int lotto) {
        return (lotto < LOTTO_NUMBER_MIN || lotto > LOTTO_NUMBER_MAX);
    }

}
