package lotto.validator;

import lotto.constant.Message.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateValidator {

    public void isNotDuplicate(String[] buyerLottoNumbers) {
        HashSet<String> set = new HashSet<>(Arrays.asList(buyerLottoNumbers));
        if (buyerLottoNumbers.length != set.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATE_NUMBER_MESSAGE.getErrorMessage());
        }
    }

    public void isNotDuplicateWithBuyerLotto(String buyerBonusNumber, int[] buyerLottoNumbers) {
        int bonusNumber = Integer.parseInt(buyerBonusNumber);
        for (int number : buyerLottoNumbers) {
            if (number == bonusNumber) {
                throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATE_NUMBER_MESSAGE.getErrorMessage());
            }
        }
    }
}