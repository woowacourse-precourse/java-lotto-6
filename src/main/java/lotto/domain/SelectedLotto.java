package lotto.domain;

import java.util.List;
import lotto.util.LottoValidator;

public class SelectedLotto {
    private List<String> numbers;
    private final SelectedNumbers selectedNumbers;
    private final SelectedBonus selectedBonus;
    private final LottoValidator validator = new LottoValidator();

    /**
     * 당첨 로또를 생성
     *
     * @param nums  당첨 로또 번호 6개
     * @param bonus 보너스 번호 1개
     */
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
