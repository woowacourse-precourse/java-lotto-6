package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoMatch {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int WINNING_MIN_COUNT = 3;
    private static final String VALIDATE_MESSAGE = "는 유효하지 않은 값입니다.";


    public Map<Rank, Integer> initializeLottoResult() {
        Map<Rank, Integer> result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, ZERO);
        }
        return result;
    }

    public Map<Rank, Integer> scoreBoard(List<Lotto> lottoNumbers, WinningLotto winningLotto) {
        Map<Rank, Integer> result = initializeLottoResult();
        for (Lotto lotto : lottoNumbers) {
            Rank rank = lottoMatch(lotto, winningLotto);
            result.put(rank, result.get(rank) + ONE);
        }
        return result;
    }

    private Rank lottoMatch(Lotto lotto, WinningLotto winningLotto) {
        int countOfMatch = lotto.countMatch(winningLotto.lotto());
        boolean matchBonus = lotto.containNumber(winningLotto.bonusNumber());

        return matchCountCheck(countOfMatch, matchBonus);
    }

    private Rank matchCountCheck(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return Rank.MISS;
        }

        if (Rank.SECOND.matchCount(countOfMatch) && matchBonus) {
            return Rank.SECOND;
        }

        return Stream.of(Rank.values())
                .filter(rank -> rank.matchCount(countOfMatch) && rank != Rank.SECOND)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(countOfMatch + VALIDATE_MESSAGE));
    }
}
