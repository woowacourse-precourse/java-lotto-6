package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayLotto {

    public static Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Lotto> makeLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        Set<List<Integer>> uniquelottos = new HashSet<>();

        while (lottoCount != 0) {
            Lotto lotto = makeLotto();
            if (uniquelottos.add(lotto.getNumbers())) {
                lottos.add(lotto);
                lottoCount--;
            }
        }
        return lottos;
    }

    public static Map<LottoResult, Integer> calculateLotto(List<Lotto> lottos, List<Integer> answerNumber, int bonusNumber) {
        Map<LottoResult, Integer> results = new EnumMap<>(LottoResult.class);

        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers(), answerNumber);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            LottoResult result = determineLottoResult(matchCount, bonusMatch);
            results.put(result, results.getOrDefault(result, 0) + 1);
        }

        return results;
    }

    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private static LottoResult determineLottoResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return LottoResult.SIX_MATCHES;
        }
        if (matchCount == 5 && bonusMatch) {
            return LottoResult.FIVE_MATCHES_WITH_BONUS;
        }
        if (matchCount == 5) {
            return LottoResult.FIVE_MATCHES;
        }
        if (matchCount == 4) {
            return LottoResult.FOUR_MATCHES;
        }
        if (matchCount == 3) {
            return LottoResult.THREE_MATCHES;
        }
        return LottoResult.NON_WINNING;
    }
}
