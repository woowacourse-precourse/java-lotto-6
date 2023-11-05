package lotto.domain;

import java.util.List;

public final class Lottos {

    private final List<Lotto> elements;

    public Lottos(final List<Lotto> elements) {
        this.elements = List.copyOf(elements);
    }

    public List<Lotto> toElements() {
        return List.copyOf(elements);
    }

    public int numOfElement() {
        return elements.size();
    }
}
