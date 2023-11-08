package lotto.domain;

import lotto.util.CompareNumber;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMoneyPrize {
    private final Map<LottoMoney, Integer> lottoResult = new EnumMap<>(LottoMoney.class);
    private final CompareNumber compareNumber = new CompareNumber();

    public LottoMoneyPrize(List<Lotto> lottos, List<Integer> randomWin, int bonusNum) {
        set();
        for (Lotto lotto : lottos) {
            int winnerNum = compareNumber.compareWinnerNum(lotto.getNumber(), randomWin);
            boolean isBonusNumber = compareNumber.compareBonusNum(bonusNum, lotto.getNumber());
            LottoMoney lottoMoney = LottoMoney.getLotto(winnerNum, isBonusNumber);
            updateLottoPrize(lottoMoney);
        }
    }

    private void set() {
        for (LottoMoney lottoMoney : LottoMoney.values()) {
            lottoResult.put(lottoMoney, 0);
        }
    }

    public int getTotalReward() {
        int total = 0;
        for (Map.Entry<LottoMoney, Integer> entry : lottoResult.entrySet()) {
            LottoMoney lottoMoney = entry.getKey();
            int count = entry.getValue();
            total += lottoMoney.getMoney() * count;
        }
        return total;
    }

    private void updateLottoPrize(LottoMoney lottoMoney) {
        lottoResult.put(lottoMoney, lottoResult.get(lottoMoney) + 1);
    }

    public Map<LottoMoney, Integer> getLottoMoneyPrize() {
        return lottoResult;
    }

}
