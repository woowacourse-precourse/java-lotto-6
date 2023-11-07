package lotto.domain;

import java.util.Objects;

public class Number {
    private static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복되는 번호입니다.";
    
    private final Lotto winningNumbers;
    private final int bonusNumber;
    
    public Number(Lotto winningNumbers, int bonusNumber) {
        Lotto.validateNumberInSpecifiedRange(bonusNumber);
        validateDuplicatedNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    
    private void validateDuplicatedNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return bonusNumber == number.bonusNumber && Objects.equals(winningNumbers, number.winningNumbers);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
