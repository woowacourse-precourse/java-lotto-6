package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottery {
    private final List<Lotto> lottery;

    public Lottery(List<Lotto> lottery) {
        this.lottery = lottery;
    }

    public String printLottoNumbers() {
        return lottery
                .stream()
                .map(Lotto::lottoNumbers)
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
    }

    public List<Rank> calLottoRank(Lotto winningNumber, LottoNumber bonusNumber) {
        List<Rank> list = new ArrayList<>();
        for (Lotto lotto : lottery) {
            Rank rank = matchLottoWinningNumber(lotto, winningNumber, bonusNumber);
            list.add(rank);
        }
        return list;
    }

    private Rank matchLottoWinningNumber(Lotto lotto, Lotto winningNumbers, LottoNumber bonusNumber) {
        return Rank.valueOf(lotto.numberOfMatches(winningNumbers), lotto.contains(bonusNumber));
    }
}
