package lotto.domain;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.ValidationConstant;

public class WinningLotto {
    private final Lotto standardNumbers;
    private final int specialNumber;

    public WinningLotto(Lotto lotto, int specialNumber) throws IllegalArgumentException{
        this.standardNumbers = lotto;
        validateSpecialNumber(specialNumber, lotto.getNumbers());
        this.specialNumber = specialNumber;
    }

    private void validateSpecialNumber(int specialNumber, List<Integer> standardNumbers) throws IllegalArgumentException {
        validateNumberSize(specialNumber);
        validateUniqueness(specialNumber, standardNumbers);
    }

    private void validateNumberSize(int specialNumber) throws IllegalArgumentException {
        if(!(specialNumber >= ValidationConstant.MIN_LOTTO_NUMBER.getNumber()
                && specialNumber <= ValidationConstant.MAX_LOTTO_NUMBER.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER_NUMBER_RANGE.getMessage());
        }
    }

    private void validateUniqueness(int specialNumber, List<Integer> standardNumbers) throws IllegalArgumentException {
        if(standardNumbers.contains(specialNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_REDUNDANT.getMessage());
        }
    }

    public Lotto getStandardNumbers() {
        return standardNumbers;
    }

    public int getSpecialNumber() {
        return specialNumber;
    }
}
