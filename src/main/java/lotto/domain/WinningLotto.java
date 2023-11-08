package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.common.Validation;

public class WinningLotto {

    private final Lotto lotto;

    private final Integer bonus;

    public WinningLotto(String strLotto, String bonus) {
        validate(strLotto, bonus);

        this.lotto = stringToList(strLotto);
        this.bonus = Integer.parseInt(bonus);
    }

    private void validate(String strLotto, String bonus) {
        Validation.blankCheck(strLotto);
        Validation.lottoDuplicateBonusNumber(strLotto, bonus);
    }

    private Lotto stringToList(String strLotto) {
        List<Integer> list = Arrays.stream(strLotto.split(","))
                .map(String::trim)
                .filter(strLottoNumber -> {
                    if (strLottoNumber.isEmpty()) {
                        return false;
                    }
                    Validation.onlyNumberCheck(strLottoNumber);
                    return true;
                })
                .map(Integer::parseInt)
                .toList();

        return new Lotto(list);
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public Integer getBonus() {
        return this.bonus;
    }
}
