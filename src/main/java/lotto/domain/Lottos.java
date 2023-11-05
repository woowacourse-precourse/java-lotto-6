package lotto.domain;

import lotto.constant.WinningGrade;

import java.util.List;
import java.util.Optional;

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

    public List<WinningGrade> compare(final Lotto lotto) {
        return elements.stream()
                .map(lotto::matchNum)
                .map(WinningGrade::valueOfMatchNum)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    public Lotto getByIndex(final int index) {
        return elements.get(index);
    }
}
