package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Collectors;

public record Lottos(List<Lotto> lottoList) {

    @Override
    public String toString() {
        return lottoList.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .collect(Collectors.joining("\n"));
    }
}
