package lotto.view;

import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.domain.Lottos;

public class numberForamat {
    public static String makeFormat(Lottos lottos) {
        return lottos.getLottos().stream()
                .map(lotto -> joinNumber(lotto))
                .collect(Collectors.joining("\n"));

    }

    public static String joinNumber(Lotto lotto) {
        return "[" +
                lotto.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "]";
    }
}
