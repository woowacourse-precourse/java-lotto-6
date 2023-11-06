package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto standardNumbers;

    public Lotto getStandardNumbers() {
        return standardNumbers;
    }

    public int getSpecialNumber() {
        return specialNumber;
    }

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
        if(!(specialNumber >= 0 && specialNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR]: 보너스 번호도 1부터 45사이여야 합니다.");
        }
    }

    private void validateUniqueness(int specialNumber, List<Integer> standardNumbers) throws IllegalArgumentException {
        if(standardNumbers.contains(specialNumber)) {
            throw new IllegalArgumentException("[ERROR]: 보너스 번호와 앞서 입력하신 6자리 숫자와 달라야 합니다.");
        }
    }
}
