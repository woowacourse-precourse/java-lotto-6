package lotto.verification;

import lotto.view.VerificationView;

public class InputMoneyVerification {

    public static void verifyRangeInputMoney(long myMoney) {
            try {
                if (myMoney / 1000 < 1 || myMoney % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                VerificationView.VerificationViewInputMoney();
            }
    }

}
