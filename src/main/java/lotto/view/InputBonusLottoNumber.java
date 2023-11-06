package lotto.view;

import lotto.exception.BlankException;
import lotto.exception.NotNumberException;

import java.util.regex.Pattern;

public class InputBonusLottoNumber {
    private static final String LOTTO_BONUS_CHOICE_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final InputThings inputThings = new InputThings();

    public void printNotice() {
        System.out.println(LOTTO_BONUS_CHOICE_MESSAGE);
    }

    public Integer buyBonusLotto() {
        printNotice();
        String bonusNumber = inputThings.inputThings().trim();
        validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public void validate(String bonusNumber) {
        blankBonusNumber(bonusNumber);
        numberValidateBonusLotto(bonusNumber);
    }

    private void blankBonusNumber(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new BlankException();
        }
    }

    private void numberValidateBonusLotto(String bonusNumber) {
        String num = "^[0-9]*$";
        if (!Pattern.matches(bonusNumber, num)) {
            throw new NotNumberException();
        }
    }

}
