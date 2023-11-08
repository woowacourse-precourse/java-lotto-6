package lotto;

import java.util.List;
import java.util.Set;

public class LottoResult {
    //로또 결과를 계산하는 기능을 추가
    public static Result calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Result result = new Result();

        for (Lotto lotto : lottos) {
            Set<Integer> intersection = lotto.findIntersection(winningNumbers);
            int matchCount = intersection.size();
            boolean hasBonus = lotto.contains(bonusNumber);

            result.update(matchCount, hasBonus);
        }

        return result;
    }
}
