package lotto.domain;

import lotto.constant.Mark;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPaper {
    private final List<Lotto> lottos;

    private LottoPaper() {
        lottos = new ArrayList<>();
    }

    private LottoPaper(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoPaper create() {
        return new LottoPaper();
    }

    public static LottoPaper copy(LottoPaper lottoPaper) {
        return new LottoPaper(lottoPaper.getLottos());
    }

    public void add(Lotto lotto) {
        lottos.add(Lotto.copy(lotto));
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
        lottos.forEach(lotto -> sb.append(lotto.toString()).append(Mark.NEW_LINE.get()));
        return sb.toString();
    }
}
