package lotto.model.dto;

import java.math.BigDecimal;
import lotto.model.calculate.LottoStatus;
import lotto.model.enums.LottoPlace;

public class WinningResultDto {
    private final int countCorrect;
    private final boolean isBonusBallCorrect;
    private final BigDecimal amount;
    private final int countLottos;

    public WinningResultDto(LottoPlace lottoPlace, int countLottos) {
        LottoStatus lottoStatus = lottoPlace.getLottoStatus();
        this.countCorrect = lottoStatus.getCorrectNumber();
        this.isBonusBallCorrect = lottoStatus.isBonusNumberCorrect();
        this.amount = lottoPlace.getPrizeAmount().getAmount();
        this.countLottos = countLottos;
    }

    public int getCountCorrect() {
        return countCorrect;
    }

    public boolean isBonusBallCorrect() {
        return isBonusBallCorrect;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getCountLottos() {
        return countLottos;
    }
}
