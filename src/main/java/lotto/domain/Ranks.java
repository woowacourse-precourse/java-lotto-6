package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Ranks {

    private final List<Rank> ranks;

    public Ranks(List<Lotto> lottery, List<Integer> winningNumber, Integer bonusNumber) {
        this.ranks = makeRankResult(lottery, winningNumber, bonusNumber);
    }

    private List<Rank> makeRankResult(List<Lotto> lottery, List<Integer> winningNumber, Integer bonusNumber) {
        List<Rank> list = new ArrayList<>();
        for (Lotto lotto : lottery) {
            Rank rank = matchLottoWinningNumber(lotto, winningNumber, bonusNumber);
            list.add(rank);
        }
        return list;
    }


    private Rank matchLottoWinningNumber(Lotto lotto, List<Integer> winningNumbers, Integer bonusNumber) {
        return Rank.valueOf(winningNumbers.size(), lotto.getNumbers().contains(bonusNumber));
    }

    public Long calWinningPrice() {
        Long resultWinningPrice = 0L;
        for (Rank rank : ranks) {
            resultWinningPrice += rank.getWinningMoney();
        }
        return resultWinningPrice;
    }
}
