package lotto;

import domain.BonusNumber;
import domain.PrizeNumber;
import domain.PurchaseAmount;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import util.ErrorMessage;

public class InputValidate {
    PurchaseAmount purchaseAmount = PurchaseAmount.getInstance();
    PrizeNumber prizeNumber = PrizeNumber.getInstance();
    BonusNumber bonusNumber = BonusNumber.getInstance();
    public void validatePurchaseAmount(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_CAN_ONLY_NUMBER.getMessage());
        }

        int purchaseAmountTemp = Integer.parseInt(inputStr);

        if (purchaseAmountTemp < 1000) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_OVER_1000.getMessage());
        }

        if (purchaseAmountTemp % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_ACCEPT_ONLY_UNIT_OF_1000.getMessage());
        }

        purchaseAmount.setPurchaseAmount(purchaseAmountTemp);
    }

    public void validatePrizeNumber(String inputStr) {
        if (!inputStr.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_CAN_ONLY_NUMBER_AND_COMMA.getMessage());
        }

        List<Integer> prizeNumberTemp = Arrays.stream(inputStr.split(","))
                .map(s -> {
                    int num = Integer.parseInt(s);
                    if (num > 45) {
                        throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_BE_UNDER_45.getMessage());
                    }
                    return num;
                })
                .collect(Collectors.toList());

        if (prizeNumberTemp.size() != new HashSet<>(prizeNumberTemp).size()) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_NOT_BE_DUPLICATED.getMessage());
        }

        if (prizeNumberTemp.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_MUST_BE_SIX_DIGITS.getMessage());
        }

        prizeNumber.setPrizeNumber(prizeNumberTemp);
    }

    public void validateBonusNumber(String inputStr) {
        if (!inputStr.matches("^\\d+$")) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_CAN_ONLY_NUMBER.getMessage());
        }

        int bonusNumberTemp = Integer.parseInt(inputStr);

        if (bonusNumberTemp > 45) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_MUST_BE_UNDER_45.getMessage());
        }

        if (prizeNumber.getPrizeNumber().contains(bonusNumberTemp)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_MUST_NOT_BE_DUPLICATED_WITH_PRIZE_NUMBER.getMessage());
        }
        bonusNumber.setBonusNumber(bonusNumberTemp);
    }
}
