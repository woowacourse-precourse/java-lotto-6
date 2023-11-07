package lotto;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class OutputManager {
    public void printLottoQuantity(int lottoQuantity) {
        System.out.println("\n" + lottoQuantity + "개를 구매했습니다.");
    }

    public void printAllLottoNumbers(List<List<Integer>> allRandomLottoNumbers) {
        for (List<Integer> randomLottoNumbers : allRandomLottoNumbers) {
            Collections.sort(randomLottoNumbers);

            StringJoiner joiner = new StringJoiner(", ", "[", "]");
            for (Integer number : randomLottoNumbers) {
                joiner.add(number.toString());
            }
            System.out.println(joiner.toString());
        }
    }
}
