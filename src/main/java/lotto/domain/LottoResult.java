package lotto.domain;


import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.NumberConstants.*;

public class LottoResult {
    private final Map<LottoRank, Integer> LOTTO_RESULT = new EnumMap<>(LottoRank.class);

    public LottoResult(List<LottoRank> lottoRanks) {
        initLottoResult();
        calculateLottoResult(lottoRanks);
    }

    private void initLottoResult() {
        List<LottoRank> lottoRanks = Arrays.stream(LottoRank.values())
                .toList();
        for (LottoRank rank : lottoRanks) {
            LOTTO_RESULT.put(rank, ZERO);
        }
    }

    private void calculateLottoResult(List<LottoRank> lottoRanks) {
        for (LottoRank rank : lottoRanks) {
            int prizeCount = LOTTO_RESULT.get(rank) + PRIZE_RAISE_COUNT;
            LOTTO_RESULT.put(rank, prizeCount);
        }
    }

    public static LottoResult createLottoResult(LottoMachine lottoPapers, WinningNumber winNum, BonusNumber bonusNum) {
        LotteryChecker lotteryChecker = new LotteryChecker(lottoPapers);
        return lotteryChecker.calculateRank(winNum, bonusNum);
    }

    public Map<LottoRank, Integer> getLOTTO_RESULT() {
        return LOTTO_RESULT;
    }
}
