package lotto.repository;

import lotto.domain.LottoPrize;
import lotto.validator.BonusNumber;
import lotto.validator.Lotto;
import lotto.validator.WinningNumbers;

import java.util.EnumMap;
import java.util.List;

public class LottoRepository {
    private List<Lotto> lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private EnumMap<LottoPrize, Integer> winCount;

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(BonusNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setWinCount(EnumMap<LottoPrize, Integer> winCount) {
        this.winCount = winCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public EnumMap<LottoPrize, Integer> getWinCount() {
        return winCount;
    }
}
