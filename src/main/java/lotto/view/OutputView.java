package lotto.view;

import lotto.domain.Lotto;

import java.util.stream.Collectors;

public class OutputView {

    public void printCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public void printLotto(Lotto lotto) {
        String numbers = lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println("[" + numbers + "]");
    }
}
