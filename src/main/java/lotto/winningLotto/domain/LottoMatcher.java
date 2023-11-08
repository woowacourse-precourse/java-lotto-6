package lotto.winningLotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.rank.domain.Rank;
import lotto.userLotto.domain.Lotto;
import lotto.userLotto.domain.Lottos;

public class LottoMatcher {

    private final WinningLotto winningLotto;

    public LottoMatcher(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public List<Rank> matchLottos(Lottos lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto userLotto : lottos.getLottos()) {
            ranks.add(matchLotto(userLotto));
        }
        return ranks;
    }

    private Rank matchLotto(Lotto userLotto) {
        int matchCount = calculateMatchCount(userLotto);
        boolean matchBonus = checkBonusMatch(userLotto);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int calculateMatchCount(Lotto userLotto) {
        return winningLotto.getLottoNumber().match(userLotto);
    }

    private boolean checkBonusMatch(Lotto userLotto) {
        return userLotto.contains(winningLotto.getLottoBonusNumber());
    }

}
