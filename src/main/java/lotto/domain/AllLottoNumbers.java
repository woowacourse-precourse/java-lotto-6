package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class AllLottoNumbers {
    private static final String LOTTOS_DELIMITER = "\n";
    private final List<Lotto> lottos;

    public AllLottoNumbers(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(LOTTOS_DELIMITER));
    }
}
