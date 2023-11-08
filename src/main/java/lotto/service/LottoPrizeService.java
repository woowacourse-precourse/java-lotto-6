package lotto.service;

import lotto.domain.lotto.enums.LottoRank;
import lotto.domain.prize.Prize;
import lotto.domain.result.LottoResult;

import java.util.EnumMap;

public class LottoPrizeService {
    public Prize createPrize(final LottoResult lottoResult) {
        EnumMap<LottoRank, Integer> lottoResultBoard = lottoResult.lottoResultBoard();
        Prize prize = Prize.of(lottoResultBoard);
        return prize;
    }
}
