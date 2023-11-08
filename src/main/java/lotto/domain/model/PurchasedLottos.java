package lotto.domain.model;

import java.util.Collections;
import java.util.List;

public final class PurchasedLottos {
    private final List<Lotto> elements;

    public PurchasedLottos(List<Lotto> elements) {
        this.elements = elements;
    }

    public List<Lotto> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public int size() {
        return elements.size();
    }
}
