package lotto;

import java.util.List;

public class PrizeDTO {
    private List<Integer> correctNumbers;
    private int bonusNumber;

    public List<Integer> getCorrectNumbers() {
        return correctNumbers;
    }

    public void setCorrectNumbers(List<Integer> correctNumbers) {
        this.correctNumbers = correctNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
