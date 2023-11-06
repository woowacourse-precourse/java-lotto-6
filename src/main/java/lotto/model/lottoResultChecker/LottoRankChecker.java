package lotto.model.lottoResultChecker;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoRankChecker {
    public Map<LottoRank, Integer> determineRank(LottoMatchingData matchingData) {
        return Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(
                        rank -> rank,
                        matchingData::getCountForRank
                ));
    }
}