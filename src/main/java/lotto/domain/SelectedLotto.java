package lotto.domain;

import java.util.List;
import lotto.util.LottoValidator;

public class SelectedLotto {
    private List<String> numbers;
    private final SelectedNumbers selectedNumbers;
    private final SelectedBonus selectedBonus;
    private final LottoValidator validator = new LottoValidator();


    public SelectedLotto(SelectedNumbers nums, SelectedBonus bonus) {
        selectedNumbers = nums;
        selectedBonus = bonus;
    }

    List<Integer> getSelectedNumbers() {
        return selectedNumbers.getSelectedNumbers();
    }

    Integer getBonus() {
        return selectedBonus.getBonus();
    }


}
