package lotto.model;

import static lotto.model.LottoRule.validateRange;
import static lotto.util.Utils.conversionInt;

public class LottoBonusNumber {
    /**
     * 보너스 번호
     */
    private final int bonusNumber;

    public LottoBonusNumber(String inNumber) {
        int number = conversionInt(inNumber);
        validateRange(number); // 보너스 번호 검증

        this.bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
