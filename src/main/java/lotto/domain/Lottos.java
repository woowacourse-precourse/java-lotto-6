package lotto.domain;

import static lotto.domain.Lotto.*;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public void inssuance(Integer purchaseAmount) {
        Integer lottoCount = purchaseAmount / PRICE;
        for (int count = 1; count <= lottoCount; count++) {
            List<Integer> numbers = pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_LENGTH);
            lottos.add(new Lotto(numbers));
        }
    }

    public Map<Grade, Integer> grade(List<Integer> winningNumbers, Integer bonusNumber) {
        Map<Grade, Integer> result = new HashMap<>();
        for (Grade grade : Grade.values()){
            result.put(grade,0);
        }
        for (Lotto lotto : lottos) {
            Grade grade = lotto.grade(winningNumbers, bonusNumber);
            result.put(grade, result.get(grade)+1);
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            stringJoiner.add(lotto.toString());
        }
        return stringJoiner.toString();
    }
}
