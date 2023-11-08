package lotto.verification;

import lotto.util.Utils;
import lotto.view.ErrorMessage;

public class Validation {

    private static final String COMMAS = ",";

    public static void verifyEmptyInputMoney(String string) {
        if (string.length() == 0) {
            ErrorMessage.verificationViewEmptyInputMoney();
            throw new IllegalArgumentException();
        }
    }

    public static void verifyRangeInputMoney(long myMoney) {
        if (myMoney / 1000 < 1 || myMoney % 1000 != 0) {
            ErrorMessage.verificationViewRangeInputMoney();
            throw new IllegalArgumentException();
        }
    }

    public static void verifyStringToLong(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            ErrorMessage.verificationViewStringToLong();
            throw new IllegalArgumentException();
        }
    }

    public static void verifyIntegerWinningLottoNumber(String string) {
        String[] lottoNumbers = string.split(COMMAS);

        for (String lottoNumber : lottoNumbers) {
            if (!Utils.isNumeric(lottoNumber)) {
                ErrorMessage.verificationViewIntegerLottoNumberList();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void verifyRangeWinningLottoNumber(String string) {
        String[] lottoNumbers = string.split(COMMAS);

        for (String lottoNumber : lottoNumbers) {
            int number = Integer.parseInt(lottoNumber);
            if (number < 1 || number > 45) {
                ErrorMessage.verificationViewRangeLottoNumber();
                throw new IllegalArgumentException();
            }
        }
    }

    public static void verifyEmptyBonusNumber(String string) {
        if (string.length() == 0) {
            ErrorMessage.verificationViewEmptyInputBonusNumber();
            throw new IllegalArgumentException();
        }
    }

    public static void verifyStringToInteger(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            ErrorMessage.verificationViewStringToInteger();
            throw new IllegalArgumentException();
        }
    }
}
