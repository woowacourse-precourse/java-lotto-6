package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.util.Parser.stringToInt;
import static lotto.util.Parser.stringToList;

public class WinningNumbers {
    Lotto lotto;
    int bonusNumber;

    public WinningNumbers(Lotto lotto, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        validateDuplication(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber){
        if(bonusNumber<1 || bonusNumber>45)
            throw new IllegalArgumentException();
    }

    private void validateDuplication(Lotto lotto, int bonusNumber) {
        if(lotto.getNumbers().contains(bonusNumber))
            throw new IllegalArgumentException();
    }



}
