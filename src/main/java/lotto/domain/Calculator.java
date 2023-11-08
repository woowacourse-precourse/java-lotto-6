package lotto.domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;

public class Calculator {
    public List<Integer> countCorrectLuckyNumbers(List<Integer> lottoNumbers, List<Integer> luckyNumbers, int bonusNumber) {
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < lottoNumbers.size(); i += 6) {
            List<Integer> batch = lottoNumbers.subList(i, Math.min(i + 6, lottoNumbers.size()));
            int count = (int) batch.stream().filter(luckyNumbers::contains).count();
            if (count == 5 && batch.contains(bonusNumber)) {
                count++;
            } else if (count == 6) {
                count++;
            }
            counts.add(count);
        }

        return counts;
    }

    public void printResult(List<Integer> counts) {
        System.out.println("결과출력: " + counts.toString());
    }

    public void rateOfReturn() {

    }
}
