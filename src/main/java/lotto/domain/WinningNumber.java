package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Lotto values;
    private BonusNumber bonusNumber;

    public WinningNumber(List<Integer> values) {
        this.values = new Lotto(values);
    }

    public void setBonusNumber(int bonusNumber) {
        validateAlreadyPickedNumber(bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validateAlreadyPickedNumber(int bonusNumber) {
        if (values.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto getValues() {
        return values;
    }
}
