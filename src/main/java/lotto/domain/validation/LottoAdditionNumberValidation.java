package lotto.domain.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static lotto.constants.LottoNumberConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoNumberConstants.MIN_LOTTO_NUMBER;

public class LottoAdditionNumberValidation {
    private static int additionNumber;
    private List<Integer> lottoWinningNumbers;
    public List<Integer> additionLottoWinningNumberValidation(String additionNumber, List<Integer> lottoWinningNumbers){
        this.lottoWinningNumbers = lottoWinningNumbers;
        LottoAdditionNumberValidation.additionNumber = convertLottoAdditionNumber(additionNumber);
        additionNumberInRange();
        additionNumberDuplicateInWinningNumber();
        return lottoWinningNumbers;
    }

    private int convertLottoAdditionNumber(String additionNumber) {
        try {
            return parseInt(additionNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : The provided addition number is not a valid integer.", e);
        }
    }

    private void additionNumberInRange() {
        if(additionNumber < MIN_LOTTO_NUMBER || additionNumber > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException("[ERROR] : The addition number is out of the valid range (" +
                    MIN_LOTTO_NUMBER + " - " + MAX_LOTTO_NUMBER + ").");
        }
    }

    private void additionNumberDuplicateInWinningNumber() {
        for (int number : lottoWinningNumbers) {
            if (number == additionNumber) {
                throw new IllegalArgumentException("[ERROR] : The addition number should not duplicate any of the main winning numbers.");
            }
        }
        lottoWinningNumbers.add(additionNumber);
    }
}
