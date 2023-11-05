package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int calculateIssueCount(int purchaseAmount) {
        final int oneLottoPrice = 1000;
        int issueCount;

        issueCount = purchaseAmount / oneLottoPrice;

        return issueCount;
    }

    public static List<Lotto> issueLotto(int issueCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < issueCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public static Map<Rank, Integer> isWin(List<Lotto> lottos, List<Integer> winNumbers, int bonusNumber) {
        final int fiveMatch = 5;
        Map<Rank, Integer> map = new HashMap<>();

        for (Lotto lotto : lottos) {
            List<Integer> issueNumbers = lotto.getNumbers();
            int matchCount = compareMatch(issueNumbers, winNumbers);

            boolean matchBonus;
            if (matchCount == fiveMatch) {
                matchBonus = compareBonus(issueNumbers, bonusNumber);
            }

        }
    }

    public static int compareMatch(List<Integer> issueNumbers, List<Integer> winNumbers) {
        int matchCount = 0;

        for (int number : issueNumbers) {
            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }
}
