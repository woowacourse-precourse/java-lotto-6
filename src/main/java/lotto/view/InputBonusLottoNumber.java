package lotto.view;

import lotto.exception.BlankException;

public class InputBonusLottoNumber {
    private static final String LOTTO_BONUS_CHOICE_MESSAGE = "보너스 번호를 입력해 주세요.";
    private InputThings inputThings = new InputThings();

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
    }

    public void blankBonusNumber(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new BlankException();
        }
    }

}
