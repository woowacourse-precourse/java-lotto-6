package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrizeLotto {
    private Lotto primaryNumbers;
    private int bonusNumber;


    public Lotto getPrimaryNumbers() {
        return primaryNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setPrimaryNumbers(Lotto primaryNumbers) {
        this.primaryNumbers = primaryNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
