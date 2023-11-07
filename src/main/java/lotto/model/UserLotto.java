package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
    public final LottoGenerator lottoGenerator = new LottoGenerator();
    public List<Lotto> userLotto = new ArrayList<>();

    public UserLotto(int lottoCnt) {
        for (int i = 0; i < lottoCnt; i++) {
            List<Integer> lottoNumbers = lottoGenerator.generate();
            userLotto.add(new Lotto(lottoNumbers));
        }
        sortEachLotto();
    }

    private void sortEachLotto() {
        for (Lotto lotto : userLotto) {
            lotto.sort();
        }
    }

    @Override
    public String toString() {
        List<String> results = userLotto.stream()
                .map(Lotto::toString)
                .toList();
        return String.join("\n", results);
    }

    public List<MatchScore> calculateMatchScores(WinningLotto winningLotto) {
        List<MatchScore> matchScores = new ArrayList<>();

        for (Lotto lotto : userLotto) {
            int matchLottoCount = lotto.calculateMatchLottoCount(winningLotto.getLotto());
            int matchBonusCount = lotto.calculateMathBonusCount(winningLotto.getBonusNumber());
            matchScores.add(new MatchScore(matchLottoCount, matchBonusCount));
        }

        return matchScores;
    }
}
