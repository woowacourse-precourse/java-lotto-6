package lotto.domain;

import lotto.validation.Validation;

import java.util.List;

public class Game {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Game(List<Integer> winningNumbers,int bonusNumber){
        validateWinningNumbers(winningNumbers);
        this.winningNumbers=winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber=bonusNumber;
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        Validation.validateNumberInRange(bonusNumber,LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER);
        Validation.validateCertainNumberDuplicateInList(winningNumbers,bonusNumber);
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        Validation.validateLength(winningNumbers,LOTTO_LENGTH);
        Validation.validateDuplicate(winningNumbers);
        Validation.validateNumberListInRange(winningNumbers,LOTTO_MIN_NUMBER,LOTTO_MAX_NUMBER);
    }


}
