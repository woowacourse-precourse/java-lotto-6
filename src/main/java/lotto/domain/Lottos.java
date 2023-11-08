package lotto.domain;

import lotto.constant.WinningGrade;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lottos {

    private static final int START_INDEX = 0;
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

    public WinningDetails compare(final Lotto lotto) {
        return IntStream.range(START_INDEX, elements.size())
                .mapToObj(index -> makeWinningDetail(lotto, index))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningDetails::new));
    }

    private Optional<WinningDetail> makeWinningDetail(final Lotto lotto, final int index) {
        final Lotto element = elements.get(index);
        final int matchNum = element.matchNum(lotto);

        return WinningGrade.valueOfMatchNum(matchNum).map(value -> new WinningDetail(value, index));
    }

    public Lotto getByIndex(final int index) {
        return elements.get(index);
    }

    public Lotto getByWinningDetail(final WinningDetail winningDetail) {
        return elements.get(winningDetail.toIndex());
    }
}
