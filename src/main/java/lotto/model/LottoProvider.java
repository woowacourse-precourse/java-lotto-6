package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoProvider {

    private static final int PLUS_COUNT = 1;
    private static final String NO = "NO";

    public List<Lotto> lottoGenerate(int each) {
        return LottoNumberCreator.myLottoNumbersOf(each);
    }

    public WinningLotto winLottoGenerate(List<Integer> numbers, int bonusNumber) {
        return WinningLotto.of(numbers, bonusNumber);
    }

    public int winningsPayments(List<LottoRank> winnings) {
        return winnings.stream()
                .filter(LottoRank::isWin)
                .mapToInt(LottoRank::myWinnings)
                .sum();
    }

    public Map<String, Integer> lottoHistory(List<LottoRank> lottoRanks) {
        Map<String, Integer> lottoHistory = mapInit();

        lottoRanks.stream()
                .filter(LottoRank::isWin)
                .map(LottoRank::name)
                .forEach(
                        (rankName) -> lottoHistory.put(
                                rankName,
                                lottoHistory.get(rankName) + PLUS_COUNT
                        )
                );

        return lottoHistory;
    }

    private Map<String, Integer> mapInit() {

        return Arrays.stream(LottoRank.values())
                .filter(
                        (rankName) -> !rankName.name()
                                .equals(NO))
                .collect(Collectors.toMap(
                        LottoRank::name, rank -> 0)
                );
    }
}
