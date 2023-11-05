package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {

    public static void printPurchaseResult(int lottoCount, Lottos lottos){
        System.out.println(lottoCount + "개를 구매했습니다.");
        printEachLotto(lottos);
    }

    private static void printEachLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printSortedNumber(lotto.getNumbers());
        }
    }

    private static void printSortedNumber(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        sortedNumbers.forEach(number -> System.out.print(number + " "));
    }

}
