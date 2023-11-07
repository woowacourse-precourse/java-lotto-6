package lotto.domain;

import lotto.constant.Format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPaper {
    List<Lotto> lottos;

    private LottoPaper() {
        lottos = new ArrayList<>();
    }

    private LottoPaper(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoPaper create() {
        return new LottoPaper();
    }

    public static LottoPaper of(List<Lotto> lottos) {
        return new LottoPaper(lottos);
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.toString()).append(Format.NEW_LINE.get()));
        return sb.toString();
    }
}
