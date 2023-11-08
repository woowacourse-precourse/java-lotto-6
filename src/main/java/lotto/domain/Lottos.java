package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Lotto.MAX_NUMBER;
import static lotto.domain.Lotto.MIN_NUMBER;
import static lotto.domain.Lotto.NUMBER_LENGTH;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public final class Lottos {
    private static final String DELIMITER = "\n";
    private static final String FORMAT = "%d개를 구매했습니다.";
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = purchaseAmount.getCount();
        for (int count = 1; count <= lottoCount; count++) {
            List<Integer> numbers = pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_LENGTH);
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    public Map<Grade, Integer> grade(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Map<Grade, Integer> result = new LinkedHashMap<>();
        for (Grade grade : Grade.values()) {
            result.put(grade, 0);
        }
        for (Lotto lotto : lottos) {
            Grade grade = lotto.grade(winningNumbers, bonusNumber);
            result.put(grade, result.get(grade) + 1);
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(DELIMITER);
        stringJoiner.add(String.format(FORMAT, lottos.size()));
        for (Lotto lotto : lottos) {
            stringJoiner.add(lotto.toString());
        }
        return stringJoiner.toString();
    }
}
