package lotto.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputHandler {
    public static StringBuilder lottosSB = new StringBuilder();

    public static void addLotto(List<Integer> numbers) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        Collections.sort(copyNumbers);
        lottosSB.append(copyNumbers.toString()).append("\n");
    }

    public void printLottos() {
        System.out.println(lottosSB.toString());
    }
}
