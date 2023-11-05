package lotto.lotto;

import java.util.List;
import java.util.stream.Collectors;

class LottoPrinter {
    static String printAll(List<Lotto> lottos) {
        int count = lottos.size();
        String prefix = String.format("%d개를 구매했습니다.\n", count);
        String body = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
        return prefix + body;
    }
}
