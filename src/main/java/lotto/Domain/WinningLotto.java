package lotto.Domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> normalNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> normalNumbers, int bonusNumber) {
        this.normalNumbers = normalNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNormalNumbers() {
        return normalNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "normalNumbers=" + normalNumbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
