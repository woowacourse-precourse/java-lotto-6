package lotto.domain;

import java.util.List;

public class Judgment {
    public int correctCount(List<Integer> lotto, List<Integer> winningLotto) {
        int result = 0;
        for (int lottoNumber : lotto) {
            if (winningLotto.contains(lottoNumber)) {
                result += 1;
            }
        }
        return result;
    }

    public boolean hasBonus(List<Integer> lotto, int bonus) {
        return lotto.contains(bonus);
    }
}
