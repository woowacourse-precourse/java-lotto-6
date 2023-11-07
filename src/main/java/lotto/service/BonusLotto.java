package lotto.service;

import java.util.List;

import static lotto.service.validator.LottoValidator.bonusNumberValidate;

public class BonusLotto {
    private final int bonusNumber;

    public BonusLotto(int bonusNumber) { //만약 예외 발생시 컨트롤러에서 예외발생시 재입력 처리를 해줘야함
        bonusNumberValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
