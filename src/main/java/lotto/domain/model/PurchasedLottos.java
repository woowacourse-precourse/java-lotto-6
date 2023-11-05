package lotto.domain.model;

import java.util.List;

public final class PurchasedLottos {
    private final List<Lotto> elements;

    public PurchasedLottos(List<Lotto> elements) {
        this.elements = elements;
    }

    public List<Lotto> getElements() {
        return elements.stream()
                .map(Lotto::getNumbers)
                .map(Lotto::new)
                .toList();
    }

    public int size() {
        return elements.size();
    }
}
