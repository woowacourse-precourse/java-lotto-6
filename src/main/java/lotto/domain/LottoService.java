package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Rank;

public class LottoService {
    private final LottoMachine lottoMachine = new LottoMachine();

    public LottoService() {
    }

    public List<Integer> checkMatchedStandardNumberWithoutBonusNumber(Lottos lottos, WinningLotto winningLotto) {
        List<Integer> result = lottos.getLottoBundle().stream()
                .map(x -> new ArrayList<>(x.getNumbers()))
                .filter(x -> !x.contains(winningLotto.getSpecialNumber()))
                .map(x -> Math.toIntExact(x.stream().
                        filter(y -> winningLotto.getStandardNumbers().getNumbers().contains(y))
                        .count())
                )
                .toList();
        return result;
    }

    public List<Integer> checkMatchedStandardNumberWithBonusNumber(Lottos lottos, WinningLotto winningLotto) {
        List<Integer> result = lottos.getLottoBundle().stream()
                .map(x -> new ArrayList<>(x.getNumbers()))
                .filter(x -> x.contains(winningLotto.getSpecialNumber()))
                .map(x -> Math.toIntExact(x.stream().
                        filter(y -> winningLotto.getStandardNumbers().getNumbers().contains(y))
                        .count())
                )
                .toList();
        return result;
    }
    public List<Rank> numberOfMatchedNumberToRank () {
        return null;
    }
}
