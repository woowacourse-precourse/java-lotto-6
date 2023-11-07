package lotto.domain;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PurchasedLottoBundle {
    private final List<Lotto> lottoBundle;

    public PurchasedLottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public WinningResults checkWinningResults(AnswerLotto answerLotto) {
        return new WinningResults(EnumSet.allOf(LottoRewardTable.class).stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        result -> lottoBundle.stream()
                                .map(answerLotto::match)
                                .map(LottoMatchingTable::of)
                                .filter(m -> Objects.equals(result.getLottoMatchingTable(), m))
                                .count(),
                        (prev, next) -> next,
                        () -> new EnumMap<>(LottoRewardTable.class)
                )));
    }

    public int getQuantity() {
        return lottoBundle.size();
    }

    public <T> List<T> convert(Function<Lotto, T> function) {
        return lottoBundle.stream().map(function)
                .collect(Collectors.toList());

    }
}
