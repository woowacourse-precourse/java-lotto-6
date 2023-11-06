package lotto;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Viewer {

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String result = lotto.getNumbers().stream().map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println("[" + result + "]");
        }
    }

    public void printWinningResult(String message, Integer count) {
        System.out.println(message + count + "개");
    }

}
