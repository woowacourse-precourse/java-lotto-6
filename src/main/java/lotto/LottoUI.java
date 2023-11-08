package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoUI {
    public static String readLine(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseResult(List<Lotto> lottos) {
        printMessage(String.format("%d개를 구매했습니다.%n", lottos.size()));
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }
}
