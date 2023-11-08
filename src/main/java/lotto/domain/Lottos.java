package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lotto.utils.LottosIterator;


public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void save(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLength() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public Iterator createIterator() {
        return new LottosIterator(this);
    }
}
