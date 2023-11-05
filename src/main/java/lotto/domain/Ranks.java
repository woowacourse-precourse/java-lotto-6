package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Ranks {

    private final List<Rank> ranks;

    public Ranks(List<Lotto> lottery, List<LottoNumber> winningNumber, LottoNumber bonusNumber) {
        this.ranks = makeRankResult(lottery, winningNumber, bonusNumber);
    }

    private List<Rank> makeRankResult(List<Lotto> lottery, List<LottoNumber> winningNumber, LottoNumber bonusNumber) {
        List<Rank> list = new ArrayList<>();
        for (Lotto lotto : lottery) {
            Rank rank = matchLottoWinningNumber(lotto, winningNumber, bonusNumber);
            list.add(rank);
        }
        return list;
    }


    private Rank matchLottoWinningNumber(Lotto lotto, List<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        HashSet<LottoNumber> set = new HashSet<>();
        set.addAll(lotto.getNumbers());
        set.retainAll(winningNumbers);
        return Rank.valueOf(set.size(), lotto.getNumbers().contains(bonusNumber));
    }

    public Long calWinningPrice() {
        Long resultWinningPrice = 0L;
        for (Rank rank : ranks) {
            resultWinningPrice += rank.getWinningMoney();
        }
        return resultWinningPrice;
    }

    public Map<Rank, Integer> lotteryRankStatus() {
        Map<Rank, Integer> lottoResult = new HashMap<>();

        for (Rank rank : ranks) {
            lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
        }
        return lottoResult;
    }
}
