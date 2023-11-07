package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoMatch {

    private static final int ZERO = 0;
    private static final int ONE = 1;


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
        return null;
    }
}
