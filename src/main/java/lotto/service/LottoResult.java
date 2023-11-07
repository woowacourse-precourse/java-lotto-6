package lotto.service;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;

public class LottoResult {

    private static final int PERCENT = 100;
    private final List<Lotto> playerLotto;
    private final List<Lotto> winningLotto;
    private final int bonus;
    private int totalPrize;
    private HashMap<LottoType, Integer> lottoStatistics;
    private LottoType lottoType;

    public LottoResult(List<Lotto> playerLotto, List<Lotto> winningLotto, int bonus) {
        this.playerLotto = playerLotto;
        this.winningLotto = winningLotto;
        this.bonus = bonus;
        this.lottoStatistics = new HashMap<>();
    }

    public void compareLotto() {
        for(Lotto lotto : playerLotto) {
            matchLottoNumber(lotto, winningLotto, bonus);
        }
    }

    private void matchLottoNumber(Lotto lotto, List<Lotto> winningLotto, int bonus) {
        for(Lotto winning : winningLotto) {
            int matchCountNumber = lotto.getMatchCount(winning);
            boolean isContainBonus = lotto.isContainBonus(bonus);
            lottoType = LottoType.of(matchCountNumber, isContainBonus);
        }
        lottoStatistics.put(lottoType, lottoStatistics.getOrDefault(lottoType, 0) + 1);
    }

    public HashMap<LottoType, Integer> getMatchLottoCountMap() {
        return lottoStatistics;
    }

    public double rateOfReturn(int price) {
        double totalPrize = statisticsLotto(lottoStatistics);
        double rateOfReturn = (totalPrize / price) * PERCENT;
        double result = (Math.round(rateOfReturn * PERCENT) / (double) PERCENT);


        return result;
    }
    private double statisticsLotto(HashMap<LottoType, Integer> lottoStatistics) {
        for(LottoType lottoType : lottoStatistics.keySet()) {
            if(lottoType == LottoType.NOTHING) {
                continue;
            }
            totalPrize = Integer.parseInt(lottoType.getPrize().replace(",", ""))
                            * lottoStatistics.get(lottoType);
        }

        return totalPrize;
    }



}
