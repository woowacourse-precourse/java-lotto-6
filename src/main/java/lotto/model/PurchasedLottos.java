package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PurchasedLottos implements Iterable<Lotto> {
    private List<Lotto> lottos;

    public PurchasedLottos() {
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
