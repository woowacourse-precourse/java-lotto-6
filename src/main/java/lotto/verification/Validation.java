package lotto.verification;

import lotto.view.VerificationView;

public class Validation {

    public static void verifyRangeInputMoney(long myMoney) {
        if (myMoney / 1000 < 1 || myMoney % 1000 != 0) {
            VerificationView.VerificationViewRangeInputMoney();
            throw new IllegalArgumentException();
        }
    }

    public static void verifyStringToLong(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            VerificationView.VerificationViewStringToLong();
            throw new IllegalArgumentException();
        }
    }

}
