package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LottoResult {

    private final LinkedHashMap<LottoRank, Integer> lottoResult = new LinkedHashMap<>();

    private final ArrayList<Lotto> purchaseLottos;
    private final WinningLotto winningLotto;

    public LottoResult(ArrayList<Lotto> purchaseLottos, WinningLotto winningLotto) {
        initLottoResult();
        this.purchaseLottos = purchaseLottos;
        this.winningLotto = winningLotto;
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
        return Arrays.stream(LottoRank.values()).filter(lottoRank -> lottoRank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(LottoRank.NO_RNAK);
    }

    public void judgeResult() {
        purchaseLottos.stream()
                .map(lotto -> {
                    int matchCount = lotto.matchCount(winningLotto);
                    boolean containBonusNumber = lotto.containLottoNumber(winningLotto.getBonusNumber());
                    LottoRank lottoRank = judgeRank(matchCount, containBonusNumber);
                    return lottoRank;
                })
                .forEach(this::saveLottoResult);
    }

    private double totalPrize() {
        long totalPrize = Arrays.stream(LottoRank.values())
                .mapToLong(lottoRank -> lottoResult.get(lottoRank) * lottoRank.getPrize())
                .sum();
        return (double) totalPrize;
    }

    public Double getTotalReturn(int purchaseAmount) {
        Double totalPirze = totalPrize();
        Double totalReturn = (totalPirze / purchaseAmount) * 100;
        return totalReturn;
    }

    public HashMap<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
