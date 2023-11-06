package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottoItems;
    private int count;

    public Lottos(List<Lotto> lottos, int count) {
        this.lottoItems = lottos;
        this.count = count;
    }


    public String getLottosNumber() {
        return lottoItems.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<Lotto> getLottoItems() {
        return lottoItems;
    }

    public int getCount() {
        return count;
    }
}
