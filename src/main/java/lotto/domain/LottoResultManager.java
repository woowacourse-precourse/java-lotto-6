package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResultManager {
    private final Map<Rank,Integer> lottoResult = new EnumMap<Rank, Integer>(Rank.class);
}
