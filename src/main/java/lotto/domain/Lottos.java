package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.configuration.Constants.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<List<Integer>> numbersList) {
        List<Lotto> lottos = new ArrayList<>();

        for (List<Integer> numbers : numbersList) {
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        this.lottos = lottos;
    }

    public List<Lotto> getRandomLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return "\n" +
                lottos.size() + Message.BUY_LOTTO +
                lottos.stream()
                        .map(Lotto::toString)
                        .collect(Collectors.joining());
    }
}
