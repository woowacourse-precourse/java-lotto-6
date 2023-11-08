package lotto;

import java.util.EnumMap;

public class LottoResult {
    private EnumMap<Match, Integer> lottoMatch = new EnumMap<>(Match.class);

    public void plusLottoResult(Match match) {
        int count = getLottoMatchCountByKey(match);
        lottoMatch.put(match, count + 1);
    }
    public int getLottoMatchCountByKey(Match match) {
        return lottoMatch.getOrDefault(match, 0);
    }
}
