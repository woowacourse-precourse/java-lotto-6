package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> elements;

    public Lottos(final List<Lotto> elements) {
        this.elements = Collections.unmodifiableList(elements);
    }

    public List<Lotto> toElements() {
        return Collections.unmodifiableList(elements);
    }
}
