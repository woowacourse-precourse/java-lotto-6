package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoResult {

    private final List<Lotto> playerLotto;
    private final List<Lotto> winningLotto;
    private LottoType lottoType;
    private final int bonus;
    private int totalPrize;
    private static final int PERCENT = 100;

    private HashMap<LottoType, Integer> lottoStatistics = new HashMap<>();


    public LottoResult(List<Lotto> playerLotto, List<Lotto> winningLotto, int bonus) {
        this.playerLotto = playerLotto;
        this.winningLotto = winningLotto;
        this.bonus = bonus;

    }

    public void compareLotto() {
        for (Lotto lotto : playerLotto) {
            matchLottoNumber(lotto, winningLotto, bonus);
        }
    }

    public LottoType matchLottoNumber(Lotto lotto, List<Lotto> winningLotto, int bonus) {
        for(Lotto winning : winningLotto) {
            int matchCountNumber = lotto.getMatchCount(winning);
            boolean isContainBonus = lotto.isContainBonus(bonus);
            lottoType = LottoType.of(matchCountNumber, isContainBonus);
        }
        countMatchLotto(lottoType);

        return lottoType;
    }

    public void countMatchLotto(LottoType lottoType) {
        lottoStatistics.put(lottoType, lottoStatistics.getOrDefault(lottoType, 0) + 1);
    }


    public HashMap<LottoType, Integer> getMatchLottoCountMap() {
        return lottoStatistics;
    }

    private void statisticsLotto(HashMap<LottoType, Integer> lottoStatistics) {
        for(LottoType lottoType : lottoStatistics.keySet()) {
            if(lottoType == LottoType.NOTHING) {
                continue;
            }
            totalPrize = Integer.parseInt(lottoType.getPrize().replace(",", ""))
                            * lottoStatistics.get(lottoType);
        }

    }

    public double rateOfReturn(int price) {
        statisticsLotto(lottoStatistics);
        double rateOfReturn =(double) totalPrize / price * PERCENT;
        rateOfReturn = Math.round(rateOfReturn * PERCENT) / (double) PERCENT;

        return rateOfReturn;
    }



}
