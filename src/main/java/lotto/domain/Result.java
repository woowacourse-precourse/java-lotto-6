package lotto.domain;

import lotto.enums.ResultStatus;

public class Result {
    private int matchCount = 0;
    private boolean hasBonusNumber = false;
    private ResultStatus resultStatus;

    public Result(int matchCount, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        setResultStatus();
    }

    public Result(WinLotto winLotto, Lotto generatedLotto) {
        for (Integer number : generatedLotto.getNumbers()) {
            setMatchCount(winLotto, number);
        }
        setHasBonusNumber(winLotto, generatedLotto);
        setResultStatus();
    }

    private void setMatchCount(WinLotto winLotto, Integer number) {
        if (winLotto.getNumbers().contains(number)) {
            this.matchCount++;
        }
    }

    private void setHasBonusNumber(WinLotto winLotto, Lotto generatedLotto) {
        if (generatedLotto.getNumbers().contains((winLotto.bonusNumber))) {
            this.hasBonusNumber = true;
        }
    }

    private void setResultStatus() {
        this.resultStatus = ResultStatus.getResultStatus(matchCount, hasBonusNumber);
    }

    public ResultStatus getResultStatus() {
        return this.resultStatus;
    }
}
