package lotto.global.validator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.LottoPrice;
import lotto.global.error.ErrorType;

public class Validator {
    public boolean isValidatePurchasePrice(String userInputPrice) {
        try {
            int userPurchasePrice = Integer.parseInt(userInputPrice);

            if (userPurchasePrice % LottoPrice.LOTTO_PRICE.getValue() != 0) {
                throw new IllegalArgumentException(ErrorType.NOT_DIVIDED_BY_MESSAGE.getValue());
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isValidateWinningNumber(String userInputWinningNumber) {
        try {
            String spaceRemovedUserInputWinningNumber = userInputWinningNumber.replace(" ", "");
            String[] userInputWinningNumberArray = spaceRemovedUserInputWinningNumber.split(",");
            List<Integer> userInputWinningNumberList = new ArrayList<>();

            for (String stringNumber : userInputWinningNumberArray) {
                int number = Integer.parseInt(stringNumber);

                if (!isValidateOutOfRange(number)) {
                    throw new IllegalArgumentException(ErrorType.OUT_OF_RANGE_NUMBER_MESSAGE.getValue());
                }

                userInputWinningNumberList.add(number);
            }

            if (userInputWinningNumberList.size() != 6) {
                throw new IllegalArgumentException(ErrorType.WRONG_LOTTO_COUNT_MESSAGE.getValue());
            }


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean isValidateBonusNumber(String userInputBonusNumber) {
        try {
            int BonusNumber = Integer.parseInt(userInputBonusNumber);
            if (!isValidateOutOfRange(BonusNumber)) {
                throw new IllegalArgumentException(ErrorType.OUT_OF_RANGE_NUMBER_MESSAGE.getValue());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean isValidateOutOfRange(int targetNumber) {
        return targetNumber >= 1 && targetNumber <= 45;
    }
}
