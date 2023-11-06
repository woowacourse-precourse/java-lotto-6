package lotto.domain;

import java.util.Optional;

public class WinnerLotto {

    private final Lotto winnerLotto;
    private final LottoNumber bounus;

    public WinnerLotto(Lotto winnerLotto, LottoNumber bounus) {
        validContainBounus(winnerLotto, bounus);
        this.winnerLotto = winnerLotto;
        this.bounus = bounus;
    }

    public Optional<Rank> calcRank(Lotto lotto) {
        return Rank.findRank(lotto.calcSimilarity(winnerLotto), lotto.contain(bounus));
    }

    private static void validContainBounus(Lotto lotto, LottoNumber bounus) {
        if (isContain(lotto, bounus)) {
            throw new IllegalArgumentException("보너스넘버가 잘못 되었습니다.");
        }
    }

    private static boolean isContain(Lotto lotto, LottoNumber bounus) {
        return lotto.contain(bounus);
    }
}
