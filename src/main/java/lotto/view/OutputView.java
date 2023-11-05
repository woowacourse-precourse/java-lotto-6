package lotto.view;

import java.util.stream.Collectors;
import lotto.Lotto;

public class OutputView {
    public static void printLotto(Lotto lotto) {
        String listString = lotto.getNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("[" + listString + "]");
    }
}
