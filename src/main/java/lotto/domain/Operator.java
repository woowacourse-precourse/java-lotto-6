package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Operator {

    private static final int LOTTO_SIZE = 6;

    public List<Integer> matchNumbers(List<Lotto> lottos, Lotto winningLotto) {
        List<Integer> corrects = new ArrayList<>();

        for (Lotto candidateLotto : lottos) {
            int correctCount = 0;
            for (int i = 0; i < LOTTO_SIZE; i++) {
                if (lottos.contains(candidateLotto.getNumbers().get(i))) {
                    correctCount++;
                }
            }
            corrects.add(correctCount);
        }
        return corrects;
    }

    public void matchBonusNumber(List<Lotto> lottos, int bonusNumber) {
        List<Integer> bonusCorrects = new ArrayList<>();

        for (Lotto candidateLotto : lottos) {
            int bonusCorrect = 0;
            if (candidateLotto.getNumbers().contains(bonusNumber)) {
                bonusCorrect++;
            }
            bonusCorrects.add(bonusCorrect);
        }
    }
}
