package lotto.domain;

import lotto.util.LottoValidator;

public class SelectedBonus {
    private final Integer selectedBonus;
    private final LottoValidator validator = new LottoValidator();

    /**
     * 보너스 번호 생성
     *
     * @param bonus           보너스 번호
     * @param selectedNumbers 당첨 번호는 보너스 검증에 필요
     */
    public SelectedBonus(String bonus, SelectedNumbers selectedNumbers) {
        validator.bonusNumber(bonus, selectedNumbers.giveSplittedNumbers());
        selectedBonus = Integer.valueOf(bonus);
    }

    Integer getBonus() {
        return selectedBonus;
    }
}
