package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    void addLotto(List<Integer> lotto) {
        lottos.add(new Lotto(lotto));
    }

    List<Result> calculateResult(Lotto winningNumber, BonusNumber bonusNumber) {
        List<Result> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Result result = lotto.countMatch(winningNumber, bonusNumber);
            if(result != null) results.add(result);
        }
        return results;
    }

    List<List<Integer>> getLottos() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos target = (Lottos) o;
        return Objects.equals(lottos, target.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
