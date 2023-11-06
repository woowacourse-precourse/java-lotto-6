package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LottoResult {

    private final LinkedHashMap<LottoRank, Integer> lottoResult = new LinkedHashMap<>();

    private final ArrayList<Lotto> purchaseLottos;
    private final WinningLotto winningLotto;

    public LottoResult(ArrayList<Lotto> purchaseLottos, WinningLotto winningLotto) {
        this.purchaseLottos = purchaseLottos;
        this.winningLotto = winningLotto;
        initLottoResult();
    }

    private void initLottoResult() {
        lottoResult.put(LottoRank.NO_RNAK, 0);
        lottoResult.put(LottoRank.FIFTH, 0);
        lottoResult.put(LottoRank.FOURTH, 0);
        lottoResult.put(LottoRank.THIRD, 0);
        lottoResult.put(LottoRank.SECOND, 0);
        lottoResult.put(LottoRank.FIRST, 0);
    }


    private void saveLottoResult(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
    }


    private LottoRank judgeRank(int matchCount, boolean containBonusNumber) {

        if (matchCount == 5 && containBonusNumber) {
            return LottoRank.SECOND;
        }
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.getMatchCount() == matchCount) {
                return lottoRank;
            }
        }
        return LottoRank.NO_RNAK;

    }

    public void judgeResult() {
        for (Lotto lotto : purchaseLottos) {
            int matchCount = lotto.matchCount(winningLotto);
            boolean containBonusNumber = lotto.containLottoNumber(winningLotto.getBonusNumber());
            LottoRank lottoRank = judgeRank(matchCount, containBonusNumber);
            saveLottoResult(lottoRank);
        }
    }

    private long totalPrize() {
        long totalPrize = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            totalPrize = lottoResult.get(lottoRank) * lottoRank.getPrize();
        }
        return totalPrize;
    }

    public Double getTotalReturn(int purchaseAmount) {
        Double totalReturn = (double) totalPrize() / purchaseAmount;
        totalReturn *= 100;
        return totalReturn;
    }

    public HashMap<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
