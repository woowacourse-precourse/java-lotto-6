package lotto.service;

import lotto.domain.*;
import lotto.dto.LottoResultDTO;

import java.util.EnumMap;
import java.util.Map;

public final class LottoResultService {
    private final WinningLotto winningLotto;
    private final PurchasedLotto purchasedLotto;

    public LottoResultService(WinningLotto winningLotto, PurchasedLotto purchasedLotto) {
        this.winningLotto = winningLotto;
        this.purchasedLotto = purchasedLotto;
    }

    public LottoResultDTO createLottoResultDto() {
        Map<LottoRankInfo, Integer> result = new EnumMap<>(LottoRankInfo.class);

        for (Lotto lotto : purchasedLotto.lotto()) {
            matchLottoRanks(result, lotto);
        }
        return convertDto(result);
    }

    private LottoResultDTO convertDto(Map<LottoRankInfo, Integer> result) {
        LottoResult lottoResult = new LottoResult(result);
        return new LottoResultDTO(lottoResult.getReturnRatio(), result);
    }

    private void matchLottoRanks(Map<LottoRankInfo, Integer> result, Lotto lotto) {
        LottoRankInfo rank = winningLotto.getLottoRank(lotto);
        result.merge(rank, 1, Integer::sum);
    }
}