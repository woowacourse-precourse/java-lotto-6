package lotto.service;

import lotto.domain.*;
import lotto.dto.LottoResultOutputDto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

public final class LottoResultService {
    private final WinningLotto winningLotto;
    private final BuyLotto buyLotto;

    public LottoResultService(WinningLotto winningLotto, BuyLotto buyLotto) {
        this.winningLotto = winningLotto;
        this.buyLotto = buyLotto;
    }

    public LottoResultOutputDto createLottoResultDto() {
        Map<LottoRankInfo, Integer> result = new EnumMap<>(LottoRankInfo.class);

        for (Lotto lotto : buyLotto.lotto()) {
            matchLottoRanks(result, lotto);
        }
        return convertDto(result);
    }

    private void matchLottoRanks(Map<LottoRankInfo, Integer> result, Lotto lotto) {
        LottoRankInfo rank = winningLotto.getLottoRank(lotto);
        result.merge(rank, 1, Integer::sum);
    }


    private LottoResultOutputDto convertDto(Map<LottoRankInfo, Integer> result) {
        LottoResult lottoResult = new LottoResult(result);
        Map<LottoRankInfo, Integer> lottoRankDto = convertLottoRanks(result);
        return new LottoResultOutputDto(lottoResult.getReturnRatio(), lottoRankDto);
    }

    private Map<LottoRankInfo, Integer> convertLottoRanks(Map<LottoRankInfo, Integer> result) {
        Map<LottoRankInfo, Integer> lottoRankDto = new TreeMap<>((r1, r2)
                -> (int) (r1.getRewardPrice() - r2.getRewardPrice()));

        Arrays.stream(LottoRankInfo.values())
                .forEach(rank -> lottoRankDto.put(rank, result.getOrDefault(rank, 0)));
        lottoRankDto.remove(LottoRankInfo.NONE);
        return lottoRankDto;
    }
}