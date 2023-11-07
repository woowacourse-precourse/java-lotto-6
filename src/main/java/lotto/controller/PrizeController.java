package lotto.controller;

import lotto.domain.lotto.enums.LottoRank;
import lotto.domain.result.LottoResult;
import lotto.domain.prize.Prize;

import java.util.EnumMap;

public class PrizeController {
    public Prize createPrizeWithLottoResult(LottoResult lottoResult){
        EnumMap<LottoRank, Integer> lottoResultBoard = lottoResult.lottoResultBoard();
        Prize prize = Prize.of(lottoResultBoard);
        return prize;
    }
}
