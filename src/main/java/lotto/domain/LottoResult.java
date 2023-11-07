package lotto.domain;

public class LottoResult {
    private Integer correctNumbers;
    private Boolean isCorrectBonusNumber;

    public LottoResult(Integer correctNumbers, Boolean isCorrectBonusNumber) {
        this.correctNumbers = correctNumbers;
        this.isCorrectBonusNumber = isCorrectBonusNumber;
    }

    public Integer getCorrectNumbers() {
        return correctNumbers;
    }

    public Boolean getCorrectBonusNumber() {
        return isCorrectBonusNumber;
    }
}
