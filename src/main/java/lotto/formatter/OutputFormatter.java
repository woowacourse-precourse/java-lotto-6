package lotto.formatter;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.stream.Collectors;

public class OutputFormatter {

    private static final String NEW_LINE = "\n";

    public String formatLottos(final Lottos lottos) {
        return lottos.toElements().stream()
                .map(Lotto::toValue)
                .map(list -> list.toString())
                .collect(Collectors.joining(NEW_LINE));
    }
}
