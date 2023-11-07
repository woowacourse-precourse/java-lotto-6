package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottoContainer;

    public Lottos(List<Lotto> lottoContainer) {
        this.lottoContainer = lottoContainer;
    }

    public void addLotto(Lotto lotto) {
        lottoContainer.add(lotto);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottoContainer);
    }

    public int countMatchingNumbers(Lotto lotto, List<Integer> winningNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        long matchingNumbers = lottoNumbers.stream()
                .map(lottoNum -> winningNumbers.contains(lottoNum))
                .distinct()
                .count();
        return (int)matchingNumbers;
    }
}
