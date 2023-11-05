package lotto.validator;

import lotto.model.Purchase;
public class ValidatorPurchaseAmount {
    public ValidatorPurchaseAmount() {
    }

    private void validatePurchaseAmount(Purchase purchase) {
        if (!isPurchaseAmountValid(purchase)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isPurchaseAmountValid(Purchase purchase) {
        boolean unitOfMoneyValid = isThousandWonMultiple(purchase);
        boolean minValueValid = isLessThan1000(purchase);
        boolean numberValid = isNotNumeric(purchase);
        boolean nonEmpty = isEmpty(purchase);
        return unitOfMoneyValid && minValueValid && numberValid && nonEmpty;
    }

    private boolean isThousandWonMultiple(Purchase purchase) {
        int returnAmount = Integer.parseInt(purchase.getPurchaseAmount());
        return returnAmount % 1000 == 0;
    }

    private boolean isLessThan1000(Purchase purchase) {
        int returnAmount = Integer.parseInt(purchase.getPurchaseAmount());
        return returnAmount >= 1000;
    }

    private boolean isNotNumeric(Purchase purchase) {
        try {
            Integer.parseInt(purchase.getPurchaseAmount());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isEmpty(Purchase purchase) {
        String returnAmount = purchase.getPurchaseAmount();
        return !returnAmount.isEmpty();
    }
}
