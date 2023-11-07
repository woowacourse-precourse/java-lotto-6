package lotto.domain.model;

import static lotto.domain.utils.ConvertUtils.convertStringToList;

public class LottoWinningNumber extends Lotto {

    private final int bonusNumber;
    public LottoWinningNumber(String stringOfWinningNumbers, int bonusNumber) {
        super(convertStringToList(stringOfWinningNumbers, ","));

        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
