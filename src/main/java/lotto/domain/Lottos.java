package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;


public class Lottos implements Iterable<Lotto> {

    private List<Lotto> lottos = new ArrayList<>();

    public int getLottoCount() {
        return lottos.size();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    @Override
    public void forEach(Consumer<? super Lotto> action) {
        lottos.forEach(action);
    }

    @Override
    public Spliterator<Lotto> spliterator() {
        return lottos.spliterator();
    }
}

