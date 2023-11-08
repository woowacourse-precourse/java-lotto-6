package lotto.domain;

import lotto.constant.LottoRanking;

import java.util.ArrayList;
import java.util.List;

public record WinningLotto(Lotto lotto, BonusNumber bonus) {

    public List<LottoRanking> checkLottoRanking(List<Lotto> checkLottos) {
        List<LottoRanking> rankings = new ArrayList<>();
        for (Lotto checkLotto : checkLottos) {
            rankings.add(checkLottoRanking(checkLotto));
        }
        return rankings;
    }

    public LottoRanking checkLottoRanking(Lotto checkLotto) {
        List<Integer> copy = new ArrayList<>(lotto.getNumbers());
        copy.retainAll(checkLotto.getNumbers());
        int matchCount = copy.size();

        boolean hasBonus = checkLotto.getNumbers().contains(bonus.bonus());

        return LottoRanking.findRanking(matchCount, hasBonus);
    }

    public static int calculateTotalPrize(List<LottoRanking> rankings) {
        int total = 0;
        for (LottoRanking ranking : rankings) {
            total += ranking.getPrize();
        }
        return total;
    }
}
