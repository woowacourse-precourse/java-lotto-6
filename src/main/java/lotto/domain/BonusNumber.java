package lotto.domain;

import java.util.List;
import lotto.domain.repository.WinningNumberRepository;
import lotto.util.ExceptionMessage;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
