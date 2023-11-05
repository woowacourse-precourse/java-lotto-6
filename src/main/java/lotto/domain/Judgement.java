package lotto.domain;

import java.util.List;

public class Judgement {
    public int compareNumbers(List<Integer> correct, List<Integer> lotto) {
        int result = 0;
        for (int i = 0; i < correct.size(); i++) {
            if (correct.contains(lotto.get(i))) {
                result++;
            }
        }
        return result;
    }
}
