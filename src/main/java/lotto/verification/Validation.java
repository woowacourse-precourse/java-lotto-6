package lotto.verification;

import lotto.view.VerificationView;

public class Validation {

    public static void verifyRangeInputMoney(String myMoney) {
        try {
            if (myMoney / 1000 < 1 || myMoney % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            VerificationView.VerificationViewInputMoney();
        }
    }

    public static void verifyStringToLong(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            VerificationView.VerificationViewStringToLong();
        }
    }

}
