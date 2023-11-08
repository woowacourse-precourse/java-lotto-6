package lotto.domain;

import lotto.validator.BonusValidator;

import java.util.ArrayList;
import java.util.List;

public class BonusLotto {

    private final String bonusNumber;
    private final List<Integer> winningNumbers = new ArrayList<>();
    public BonusLotto(String bonusNumber, List<Integer> winningNumbers) {
        BonusValidator.validate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber() {
        return Integer.parseInt(bonusNumber);
    }
}
