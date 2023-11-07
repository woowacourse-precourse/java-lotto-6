package lotto.domain.result;

import lotto.domain.lotto.enums.LottoRank;

import java.util.EnumMap;
import java.util.List;

public record LottoResult(EnumMap<LottoRank, Integer> lottoResultBoard) {
    public static LottoResult of(List<LottoRank> lottoRanks) {
        EnumMap<LottoRank, Integer> board = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : lottoRanks) {
            int count = board.getOrDefault(lottoRank, 0);
            board.put(lottoRank, count + 1);
        }
        return new LottoResult(board);
    }
}

