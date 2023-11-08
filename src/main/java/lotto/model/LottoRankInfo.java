package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoRankInfo {
    private final static int BASIC_SETTING_VALUE = 0;
    private final static int MAP_INCREASE_VALUE = 1;
    private final Map<LottoRank, Integer> lottoRankInfo;

    private LottoRankInfo(Map<LottoRank, Integer> lottoRankInfo) {
        this.lottoRankInfo = lottoRankInfo;
    }

    public static LottoRankInfo from(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> lottoRankInfo = new EnumMap(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> lottoRankInfo.putIfAbsent(lottoRank, BASIC_SETTING_VALUE));
        lottoRanks.stream()
                .forEach(lottoRank -> lottoRankInfo.put(lottoRank, lottoRankInfo.get(lottoRank) + MAP_INCREASE_VALUE));
        return new LottoRankInfo(lottoRankInfo);
    }

    public Map<LottoRank, Integer> getLottoRankInfo() {
        return Collections.unmodifiableMap(this.lottoRankInfo);
    }


}
