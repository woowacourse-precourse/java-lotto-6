package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public record Tickets(List<Lotto> lottos) {
    
    public static Tickets generate(int count) {
        return new Tickets(IntStream.range(0, count).mapToObj(i -> Lotto.generate()).toList());
    }

    @Override
    public String toString() {
        return lottos
                .stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
