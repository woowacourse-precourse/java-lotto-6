package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> checkWinning(List<Integer> winningNumber) {
        return lottos.stream()
                .map(lotto -> lotto.checkNumbers(winningNumber))
                .collect(Collectors.toList());
    }
}