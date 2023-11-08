package lotto.Domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> normalNumbers;


    private int bonusNumber;

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

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "normalNumbers=" + normalNumbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
