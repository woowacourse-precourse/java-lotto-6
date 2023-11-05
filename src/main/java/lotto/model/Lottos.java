package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto() {
        Lotto newLotto = new Lotto(RandomNumbersGenerator.generate());
        lottos.add(newLotto);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
