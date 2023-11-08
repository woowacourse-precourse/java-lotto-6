package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(List<Integer> numbers) {
        lottos.add(new Lotto(numbers));
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
