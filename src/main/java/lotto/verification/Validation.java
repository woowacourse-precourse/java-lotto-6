package lotto.verification;

import lotto.util.Utils;
import lotto.view.VerificationView;

public class Validation {

    private static final String COMMAS = ",";

    public static void verifyRangeInputMoney(long myMoney) {
        if (myMoney / 1000 < 1 || myMoney % 1000 != 0) {
            VerificationView.verificationViewRangeInputMoney();
            throw new IllegalArgumentException();
        }
    }

    public static void verifyStringToLong(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            VerificationView.verificationViewStringToLong();
            throw new IllegalArgumentException();
        }
    }

    public static void verifyStringToInteger(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            VerificationView.verificationViewStringToInteger();
            throw new IllegalArgumentException();
        }
    }

    public static void verifyRangeWinningLottoNumber(String string) {
        String[] lottoNumbers = string.split(COMMAS);

        for (String lottoNumber : lottoNumbers) {
            int number = Integer.parseInt(lottoNumber);
            if (number < 1 || number > 45) {
                VerificationView.verificationViewRangeLottoNumber();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void verifyIntegerWinningLottoNumber(String string) {
        String[] lottoNumbers = string.split(COMMAS);

        for (String lottoNumber : lottoNumbers) {
            if (!Utils.isNumeric(lottoNumber)) {
                VerificationView.verificationViewIntegerLottoNumberList();
                throw new IllegalArgumentException();
            }
        }
    }

}
