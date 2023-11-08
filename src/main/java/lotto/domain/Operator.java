package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Operator {
    public void matchNumbers(List<Lotto> lottos, Lotto winningLotto) {
        List<Integer> corrects = new ArrayList<>();

        for (Lotto candidateLotto : lottos) {
            int correctCount = 0;
            for (int i = 0; i < candidateLotto.getNumbers().size(); i++) {
                if (lottos.contains(candidateLotto.getNumbers().get(i))) {
                    correctCount++;
                }
            }
            corrects.add(correctCount);
        }
    }
}
