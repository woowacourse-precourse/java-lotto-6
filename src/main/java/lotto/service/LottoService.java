package lotto.service;

import static lotto.common.util.LottoUtil.MAX;
import static lotto.common.util.LottoUtil.MIN;
import static lotto.common.util.LottoUtil.RANK_FIVE;
import static lotto.common.util.LottoUtil.RANK_FOUR;
import static lotto.common.util.LottoUtil.RANK_ONE;
import static lotto.common.util.LottoUtil.RANK_THREE;
import static lotto.common.util.LottoUtil.RANK_TWO;
import static lotto.common.util.LottoUtil.SIZE;
import static lotto.common.util.LottoUtil.THOUSAND;
import static lotto.common.util.LottoUtil.ZERO;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.common.Validation;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoService {

    public Integer buyLottoCount(Integer buyPrice) {
        Validation.lottoPriceCheck(buyPrice);
        return buyPrice / THOUSAND.getNumber();
    }

    public List<Lotto> getRandomLotto(Integer buyLottoCount) {
        return IntStream.range(ZERO.getNumber(), buyLottoCount)
                .mapToObj(i -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(MIN.getNumber(), MAX.getNumber(), SIZE.getNumber())))
                .toList();
    }

    public Buyer setBuyer(List<Lotto> randomLotto) {
        return new Buyer(randomLotto);
    }

    public WinningLotto setWinningLotto(String strLotto, String strBonus) {
        return new WinningLotto(strLotto, strBonus);
    }

    public Rank setLottoResult(Buyer buyer, WinningLotto winningLotto) {
        List<Lotto> buyerLottos = buyer.getLottos();

        Lotto winningLottoNumbers = winningLotto.getLotto();
        Integer winningBonus = winningLotto.getBonus();

        return getRanking(buyerLottos, winningLottoNumbers, winningBonus);
    }

    private Rank getRanking(List<Lotto> buyerLottos, Lotto winningLottoNumbers, Integer winningBonus) {
        Rank rank = new Rank();
        buyerLottos
                .forEach(lotto -> {
                    int matchCount = countMatchingNumbers(lotto, winningLottoNumbers);
                    setRanking(winningBonus, lotto, matchCount, rank);
                });

        return rank;
    }

    private static void setRanking(Integer winningBonus, Lotto lotto, int matchCount, Rank rank) {
        five(matchCount, rank);
        four(matchCount, rank);
        three(winningBonus, lotto, matchCount, rank);
        two(winningBonus, lotto, matchCount, rank);
        one(matchCount, rank);
    }

    private static void one(int matchCount, Rank rank) {
        if (matchCount == RANK_ONE.getNumber()) {
            rank.one();
        }
    }

    private static void two(Integer winningBonus, Lotto lotto, int matchCount, Rank rank) {
        if (matchCount == RANK_TWO.getNumber() && lotto.getNumbers().contains(winningBonus)) {
            rank.two();
        }
    }

    private static void three(Integer winningBonus, Lotto lotto, int matchCount, Rank rank) {
        if (matchCount == RANK_THREE.getNumber() && !lotto.getNumbers().contains(winningBonus)) {
            rank.three();
        }
    }

    private static void four(int matchCount, Rank rank) {
        if (matchCount == RANK_FOUR.getNumber()) {
            rank.four();
        }
    }

    private static void five(int matchCount, Rank rank) {
        if (matchCount == RANK_FIVE.getNumber()) {
            rank.five();
        }
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        int count = ZERO.getNumber();
        for (Integer number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }
}
