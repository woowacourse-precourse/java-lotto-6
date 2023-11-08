package lotto.model;

import static lotto.enums.ErrorMessage.NEGATIVE_NUM_ERROR;

import java.util.List;
import lotto.enums.ErrorMessage;

public class LottoResultPolicy implements ResultPolicy {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @Override
    public LottoResult calculateResult(Lotto lotto) {
        int winningCount = checkLottoNumber(lotto.getNumbers());
        boolean bonusMatch = checkBonusNumber(lotto.getNumbers());
        return new LottoResult(winningCount, bonusMatch);
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private int checkLottoNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }

    private boolean checkBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
            .anyMatch(number -> number == bonusNumber);
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        LottoNumberValidator.validateNumbersSize(numbers);
        LottoNumberValidator.validateNumberRange(numbers);
        LottoNumberValidator.validateDuplicateNumbers(numbers);
    }

    private void validateBonusNumber(int bonusNumbers) {
        validateNegativeNum(bonusNumbers);
        validateNumberRange(bonusNumbers);
        validateDuplicateNumber(bonusNumbers);
    }

    private void validateNegativeNum(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUM_ERROR.getMessage());
        }
    }

    private void validateNumberRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.EXCEED_LOTTO_RANGE_ERROR.getMessage());
        }
    }

    private void validateDuplicateNumber(int bonusNumber) throws IllegalArgumentException {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                ErrorMessage.DUPLICATE_WINNING_NUMBER_ERROR.getMessage());
        }
    }

}
