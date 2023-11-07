package lotto.controller;

import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.Prize;

import java.util.EnumMap;

public class PrizeController {
    public Prize createPrizeWithLottoResult(LottoResult lottoResult){
        EnumMap<LottoRank, Integer> lottoResultBoard = lottoResult.lottoResultBoard();
        Prize prize = Prize.of(lottoResultBoard);
        return prize;
    }
}
