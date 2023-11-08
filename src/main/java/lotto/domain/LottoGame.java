package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class LottoGame {
    private final Long purchaseAmount;
    private final Long lottoCnt;
    private List<Lotto> lottos;

    private Lotto winningNumber;

    private int bonusNumber;

    private final EnumMap<LottoStatistic, Integer> lottoResult;
    private static final int lottoPrice = 1000;
    public LottoGame(Long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoCnt = purchaseAmount/lottoPrice;
        lottoResult = new EnumMap<>(LottoStatistic.class);
        for (LottoStatistic ls : LottoStatistic.values()) {
            lottoResult.put(ls, 0);
        }
    }

    public Long getPurchaseAmount() {
        return purchaseAmount;
    }

    public Long getLottoCnt() { return lottoCnt;}

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

    public void lottoResultToString() {
        List<LottoStatistic> reversedList = Arrays.asList(LottoStatistic.values());
        Collections.reverse(reversedList);
        for (LottoStatistic key :
                reversedList) {
            System.out.println(key.getMessage() + " - " + lottoResult.get(key) + "개");
        }
    }


}
