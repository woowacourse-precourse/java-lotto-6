package lotto.domain;

import java.util.List;

public class LottoResult {
    private List<Integer> correctNumbers;
    private Boolean isCorrectBonusNumber;

    public LottoResult(List<Integer> correctNumbers, Boolean isCorrectBonusNumber) {
        this.correctNumbers = correctNumbers;
        this.isCorrectBonusNumber = isCorrectBonusNumber;
    }

    public List<Integer> getCorrectNumbers() {
        return correctNumbers;
    }

    public Boolean getCorrectBonusNumber() {
        return isCorrectBonusNumber;
    }
}
