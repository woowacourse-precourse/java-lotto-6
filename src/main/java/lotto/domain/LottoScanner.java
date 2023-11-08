package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lotto.constant.Rank;

public class LottoScanner {
    public LottoScanner() {
    }

    public List<Rank> sendAnalyzedResult (Lottos lottos, WinningLotto winningLotto) {
        List<Rank> withBonusNumber = checkMatchedStandardNumberWithBonusNumber(lottos, winningLotto).stream()
                .map(x -> Rank.matchedNumberToRank(x, 1))
                .flatMap(Optional::stream)
                .toList();

        List<Rank> withoutBonusNumber = checkMatchedStandardNumberWithoutBonusNumber(lottos, winningLotto).stream()
                .map(x -> Rank.matchedNumberToRank(x, 0))
                .flatMap(Optional::stream)
                .toList();

        return Stream.of(withBonusNumber, withoutBonusNumber)
                .flatMap(Collection::stream)
                .sorted()
                .toList();
    }

    private  List<Integer> checkMatchedStandardNumberWithoutBonusNumber(Lottos lottos, WinningLotto winningLotto) {
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

     private List<Integer> checkMatchedStandardNumberWithBonusNumber(Lottos lottos, WinningLotto winningLotto) {
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
}
