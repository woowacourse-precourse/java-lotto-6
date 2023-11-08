package lotto.service;

import java.util.HashMap;
import java.util.HashSet;
import lotto.domain.PurchasedLotto;
import lotto.dto.LottoResultDto;
import lotto.dto.WinningLottoDto;
import lotto.util.ProfitRateCalculator;

public class LottoResultService {
    public LottoResultDto generateLottoResult(HashSet<PurchasedLotto> purchasedLotto,
                                              WinningLottoDto dto, int purchasedLottoCount) {
        HashMap<LottoRank, Integer> map = countWinningRanks(purchasedLotto, dto);
        int firstPrizeCount = map.getOrDefault(LottoRank.FIRST, 0);
        int secondPrizeCount = map.getOrDefault(LottoRank.SECOND, 0);
        int thirdPrizeCount = map.getOrDefault(LottoRank.THIRD, 0);
        int fourthPrizeCount = map.getOrDefault(LottoRank.FOURTH, 0);
        int fifthPrizeCount = map.getOrDefault(LottoRank.FIFTH, 0);
        String profitRate = calculateProfitRate(firstPrizeCount, secondPrizeCount, thirdPrizeCount,
                fourthPrizeCount, fifthPrizeCount, purchasedLottoCount);

        return new LottoResultDto(firstPrizeCount, secondPrizeCount, thirdPrizeCount,
                fourthPrizeCount, fifthPrizeCount, profitRate);
    }
    private HashMap<LottoRank, Integer> countWinningRanks(HashSet<PurchasedLotto> purchasedLotto, WinningLottoDto dto) {
        HashMap<LottoRank, Integer> lottoResult = new HashMap<>();

        for (PurchasedLotto lotto : purchasedLotto) {
            lotto.compare(dto);
            LottoRank rank = lotto.toDto().rank();

            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }

        return lottoResult;
    }

    private String calculateProfitRate(int firstPrizeCount, int secondPrizeCount, int thirdPrizeCount,
                                       int fourthPrizeCount, int fifthPrizeCount, int purchasedLottoCount) {
        return ProfitRateCalculator.calculate(firstPrizeCount, secondPrizeCount, thirdPrizeCount,
                fourthPrizeCount, fifthPrizeCount, purchasedLottoCount);
    }
}
