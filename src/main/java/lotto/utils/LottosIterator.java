package lotto.utils;

import java.util.Iterator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottosIterator implements Iterator<Lotto> {

    private Lottos lottos;
    private int index = 0;

    public LottosIterator(Lottos lottos) {
        this.lottos = lottos;
    }
    @Override
    public boolean hasNext() {
        return index < lottos.getLength();
    }

    @Override
    public Lotto next() {
        Lotto lotto = lottos.getLotto(index);
        index++;
        return lotto;
    }
}
