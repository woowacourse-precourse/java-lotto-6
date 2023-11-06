package lotto.view;

import lotto.exception.BlankException;
import lotto.exception.NotNumberException;
import lotto.exception.RangeLottoNumberException;

import static lotto.domain.Constant.MIN_RANGE;
import static lotto.domain.Constant.MAX_RANGE;

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
        validateBonusIsNumber(bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void blankBonusNumber(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new BlankException();
        }
    }

    public boolean isNumberString(String bonusNumber) {
        if(bonusNumber.isBlank()) {
            return false;
        }
        for (int i = 0; i < bonusNumber.length(); i++) {
            char uncheckedCharacter = bonusNumber.charAt(i);
            if(!Character.isDigit(uncheckedCharacter)) {
                return false;
            }
        }
        return true;
    }

    public void validateBonusIsNumber(String bonusNumber) {
        if(!isNumberString(bonusNumber)) {
            throw new NotNumberException();
        }
    }

    public void validateBonusNumberRange(String uncheckedInput) {
        int bonusNumber = Integer.parseInt(uncheckedInput);
        if(bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new RangeLottoNumberException();
        }
    }
}
