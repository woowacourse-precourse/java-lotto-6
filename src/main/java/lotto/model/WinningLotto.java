package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto{
    private final Integer bonusNumber;

    public WinningLotto(String lottoNumbers, String bonusNumber) {
        super(lottoNumbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = convertStringToInteger(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber) {
        validateCastingBeforeBonusNumber(bonusNumber);
        validateCastingAfterBonusNumber(convertStringToInteger(bonusNumber));
    }

    private void validateCastingBeforeBonusNumber(String bonusNumber) {
        validateNotNullBonusNumber(bonusNumber);
        validateNonNumericBonusNumber(bonusNumber);
    }

    private void validateCastingAfterBonusNumber(Integer bonusNumber) {
        vaildateOutOfRangeBonusNumber(bonusNumber);
        vaildateLottoNumbersContainBonusNumber(bonusNumber);
    }

    private void validateNotNullBonusNumber(String bonusNumber) {
        if (bonusNumber == null) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");
        }
    }

    private void validateNonNumericBonusNumber(String bonusNumber) {
        if (!bonusNumber.matches("\\d+")) {
            throw new IllegalArgumentException("[Error] 보너스 번호에 숫자가 아닌 값이 들어왔습니다.");
        }
    }

    private void vaildateOutOfRangeBonusNumber(Integer bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 지정된 범위안의 숫자만 가질 수 있습니다. 범위 "
                    + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
        }
    }

    private void vaildateLottoNumbersContainBonusNumber(Integer bonusNumber) {
        if (super.isInputNumberContainLottoNumbers(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 겹치면 안됩니다.");
        }
    }

    private Integer convertStringToInteger(String bonusNumber) {
        Integer convertBonusNumber;

        try {
            convertBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 지정된 범위안의 숫자만 가질 수 있습니다. 범위 "
                    + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
        }
        return convertBonusNumber;
    }
}
