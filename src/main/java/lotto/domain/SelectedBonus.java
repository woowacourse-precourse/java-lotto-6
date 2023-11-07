package lotto.domain;

import lotto.util.LottoValidator;

public class SelectedBonus {
    private final Integer selectedBonus;
    private final LottoValidator validator = new LottoValidator();

    public SelectedBonus(String bonus, SelectedNumbers selectedNumbers) {
        validator.bonusNumber(bonus, selectedNumbers.giveSplittedNumbers());
        selectedBonus = Integer.valueOf(bonus);
    }

    Integer getBonus() {
        return selectedBonus;
    }
}
