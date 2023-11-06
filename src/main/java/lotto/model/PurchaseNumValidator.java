package lotto.model;

import lotto.Constants;

public class PurchaseNumValidator {
        public final String PURCHASE_STRING;
        public PurchaseNumValidator(String purchaseNumString) {
                this.PURCHASE_STRING = purchaseNumString;
                validate();
        }

        public void validate() {
                isMultipleOf1000();
        }

        public void isMultipleOf1000() {
                // 입력한 구입금액이 1000단위인지 확인
                if (Integer.parseInt(PURCHASE_STRING) % 1000 != 0) {
                        throw new IllegalArgumentException(Constants.PURCHASE_UNIT_ERROR);
                }
        }
}
