package lotto.domain.validation;

import lotto.constants.ErrorMassageConstants;

import java.util.List;

import static java.lang.Integer.parseInt;
import static lotto.constants.LottoNumberConstants.*;

public class LottoAdditionNumberValidation {
    private static int additionNumber;
    private List<Integer> lottoWinningNumbers;
    public List<Integer> additionLottoWinningNumberValidation(String additionNumber, List<Integer> lottoWinningNumbers){
        this.lottoWinningNumbers = lottoWinningNumbers;
        LottoAdditionNumberValidation.additionNumber = convertLottoAdditionNumber(additionNumber);
        additionNumberInRange();
        additionNumberDuplicateInWinningNumber();
        additionNumberByOverSize();
        return lottoWinningNumbers;
    }

    private int convertLottoAdditionNumber(String additionNumber) {
        try {
            return parseInt(additionNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMassageConstants.CONVERT_ADDITION_NUMBER_ERROR_MESSAGE.getMessage(), e);
        }
    }

    private void additionNumberInRange() {
        if(additionNumber < MIN_LOTTO_NUMBER || additionNumber > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException(ErrorMassageConstants.ADDITION_NUMBER_IN_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void additionNumberDuplicateInWinningNumber() {
        for (int number : lottoWinningNumbers) {
            if (number == additionNumber) {
                throw new IllegalArgumentException(ErrorMassageConstants.ADDITION_NUMBER_DUPLICATE_ERROR_MESSAGE.getMessage());
            }
        }
        lottoWinningNumbers.add(additionNumber);
    }

    private void additionNumberByOverSize() {
        if (lottoWinningNumbers.size() != LOTTO_WINNING_NUMBER_RANGE) {
            throw new IllegalArgumentException(ErrorMassageConstants.ADDITION_NUMBER_SIZE_OVER_ERROR_MESSAGE.getMessage());
        }
    }
}
