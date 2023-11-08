package lotto.model;

import lotto.Constants;
import lotto.view.InputView;

import java.util.regex.Matcher;

public class PurchaseAmountValidator {
        public final String PURCHASE_STRING;
        public PurchaseAmountValidator(String purchaseNumString) {
                this.PURCHASE_STRING = purchaseNumString;
                validate();
        }

        public void validate() {
                isMultipleOf1000();
                isRightNumRange();
        }

        public void isMultipleOf1000() {
                if (Integer.parseInt(PURCHASE_STRING) % 1000 != 0) {
                        throw new IllegalArgumentException(Constants.PURCHASE_UNIT_ERROR);
                }
        }

        public static int setQuantity() {
                try {
                        PurchaseAmountValidator validation = new PurchaseAmountValidator(InputView.purchaseInput());
                        int purchaseAmount = Integer.parseInt(validation.PURCHASE_STRING);
                        Quantity quantity = new Quantity(purchaseAmount);
                        return quantity.quantityNum;
                } catch (IllegalArgumentException e) {
                        System.out.println(Constants.PURCHASE_WRONG_ERROR);
                        return setQuantity();
                }
        }

        public boolean isNumInRange(String input) {
                Matcher matcher = Constants.purchasePattern.matcher(input);
                if (matcher.matches()) {
                        int number = Integer.parseInt(input);
                        return true;
                }
                return false;
        }

        public void isRightNumRange() {
                boolean valid = isNumInRange(PURCHASE_STRING);
                if (!valid) {
                        throw new IllegalArgumentException(Constants.PURCHASE_WRONG_ERROR);
                }
        }
}
