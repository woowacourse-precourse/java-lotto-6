package lotto.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printIssuedLottoDetails(int lottoQuantity, List<String> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottoQuantity);
        lottos.forEach(System.out::println);
    }
}
