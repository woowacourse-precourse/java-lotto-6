package lotto.domain;

import lotto.constant.WinningAmount;

public class WinningLotto {
    private final Boolean isBonusNumberMatch;
    private final Integer generalNumberMatchCount;

    public WinningLotto(Boolean isBonusNumberMatch, Integer generalNumberMatchCount) {
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.generalNumberMatchCount = generalNumberMatchCount;
    }

    public Boolean getIsBonusNumberMatch() {
        return isBonusNumberMatch;
    }

    public Integer getGeneralNumberMatchCount() {
        return generalNumberMatchCount;
    }

    @Override
    public String toString() {
        return generalNumberMatchCount + "개 일치" + (isBonusNumberMatch ? ", 보너스 볼 일치" : "") + "("
                + WinningAmount.getWinningAmount(generalNumberMatchCount, isBonusNumberMatch) + "원)";
    }

    public boolean isThird() {
        return generalNumberMatchCount == 5 && !isBonusNumberMatch;
    }
}
