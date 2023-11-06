package lotto.domain;

import lotto.utils.ValidateUtils;

import java.util.List;

public class BonusNumber {
    private final int BONUS_SIZE = 1;
    private final int bonusNumber;
    private ValidateUtils validateUtils = new ValidateUtils();

    public BonusNumber(int bonusNumber, Lotto lotto) {
        lotto.lottoContainNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(String inputString, Lotto lotto) {
        ValidateUtils.validateNumeric(inputString);

        return new BonusNumber(Integer.parseInt(inputString), lotto);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
