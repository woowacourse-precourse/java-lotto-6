package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class LottoGame {
    private Long purchaseAmount;

    private List<Lotto> lottos;

    private Lotto winningNumber;

    private int bonusNumber;

    private final EnumMap<LottoStatistic, Integer> lottoResult;
    public LottoGame(Long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        lottoResult = new EnumMap<>(LottoStatistic.class);
        for (LottoStatistic ls : LottoStatistic.values()) {
            lottoResult.put(ls, 0);
        }
    }

    public Long getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void setStatisticMap(LottoStatistic lottoStatistic) {
        this.lottoResult.put(lottoStatistic, lottoResult.get(lottoStatistic)+1);
    }
}
