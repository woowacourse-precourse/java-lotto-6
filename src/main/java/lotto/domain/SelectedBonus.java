package lotto.domain;

import java.util.List;
import lotto.util.LottoValidator;

public class SelectedBonus {
    private final Integer selectedBonus;
    private final LottoValidator validator = new LottoValidator();

    public SelectedBonus(String bonus, List<String> splittedNumbers) {
        validator.bonusNumber(bonus, splittedNumbers);
        selectedBonus = Integer.valueOf(bonus);
    }

    Integer getBonus() {
        return selectedBonus;
    }
}
