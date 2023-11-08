package lotto.domain;

import java.util.Objects;
import lotto.utils.generator.LottoGenerator;

public class BonusNumber {
    public static final int START_INCLUSIVE = LottoGenerator.START_INCLUSIVE;
    public static final int END_INCLUSIVE = LottoGenerator.END_INCLUSIVE;

    public static final String INVALID_NUMBER_FORMAT_MESSAGE = "보너스 번호는 숫자만 입력할 수 있습니다.";
    public static final String INVALID_NUMBER_RANGE_MESSAGE = "번호의 범위는 " + START_INCLUSIVE + " ~ " + END_INCLUSIVE + "로 입력할 수 있습니다.";

    private final int bonusNumber;

    public BonusNumber(String bonusNumberText) {
        validate(bonusNumberText);
        this.bonusNumber = toInt(bonusNumberText);
    }

    private void validate(String bonusNumberText) {
        int bonusNumber = toInt(bonusNumberText);
        validateNumberRange(bonusNumber);
    }

    private int toInt(String bonusNumberText) {
        try {
            return Integer.parseInt(bonusNumberText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE, e);
        }
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < START_INCLUSIVE || bonusNumber > END_INCLUSIVE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
