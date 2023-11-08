package lotto.domain;

import static java.util.stream.Collectors.toMap;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.function.Function;

public class PurchasedLottoBundle {

    private final List<Lotto> lottoBundle;

    public PurchasedLottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public WinningResults checkWinningResults(AnswerLotto answerLotto) {
        return new WinningResults(EnumSet.allOf(LottoRewardTable.class)
                .stream()
                .collect(toMap(Function.identity(),
                        lottoRewardTable -> calculateMatchCount(answerLotto, lottoRewardTable),
                        (prev, next) -> next,
                        () -> new EnumMap<>(LottoRewardTable.class)
                )));
    }

    private long calculateMatchCount(AnswerLotto answerLotto, LottoRewardTable lottoRewardTable) {
        return lottoBundle.stream()
                .map(answerLotto::match)
                .map(LottoMatchingTable::of)
                .filter(lottoRewardTable::hasSameRank)
                .count();
    }

    public int getQuantity() {
        return lottoBundle.size();
    }

    public <T> List<T> convert(Function<Lotto, T> function) {
        return lottoBundle.stream()
                .map(function)
                .toList();
    }

}
