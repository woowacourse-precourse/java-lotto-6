package lotto.UI;

import java.util.List;

public class OutputHandler {
    public static StringBuilder lottosSB = new StringBuilder();

    public static void addLotto(List<Integer> numbers) {
        lottosSB.append(numbers.toString()).append("\n");
    }

    public void printLottos() {
        System.out.println(lottosSB.toString());
    }
}
