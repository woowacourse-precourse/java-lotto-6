package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoPurchaseInfo {
    private final List<Lotto> lottos;
    private int count;

    public LottoPurchaseInfo(List<Lotto> lottos, int count) {
        this.lottos = lottos;
        this.count = count;
    }


    public String getLottosNumber() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return count;
    }
}
