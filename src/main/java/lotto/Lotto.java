package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int calculateIssueCount(int purchaseAmount) {
        final int oneLottoPrice = 1000;

        int issueCount = purchaseAmount / oneLottoPrice;

        return issueCount;
    }

    public static List<Lotto> issueLotto(int issueCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < issueCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            lottos.add(new Lotto(sortedNumbers));
        }

        return lottos;
    }

    public static Map<Rank, Integer> isWin(List<Lotto> lottos, List<Integer> winNumbers, int bonusNumber) {
        final int fiveMatch = 5;
        Map<Rank, Integer> lottoResult = new HashMap<>();
        setInitialValue(lottoResult);
        for (Lotto lotto : lottos) {
            List<Integer> issueNumbers = lotto.getNumbers();
            int matchCount = compareMatch(issueNumbers, winNumbers);
            boolean matchBonus = false;
            if (matchCount == fiveMatch) {
                matchBonus = compareBonus(issueNumbers, bonusNumber);
            }
            saveLottoResult(lottoResult, matchCount, matchBonus);
        }
        return lottoResult;
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

    public static boolean compareBonus(List<Integer> issueNumbers, int bonusNumber) {
        if (issueNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public static void setInitialValue(Map<Rank, Integer> lottoResult) {
        final int initialCount = 0;

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            lottoResult.put(rank, initialCount);
        }
    }

    public static void saveLottoResult(Map<Rank, Integer> lottoResult, int matchCount, boolean matchBonus) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (rank.getMatchCount() == matchCount && rank.isMatchBonus() == matchBonus) {
                int oldValue = lottoResult.get(rank);
                int newValue = ++oldValue;
                lottoResult.replace(rank, newValue);
            }
        }
    }

    public static double calculateReturnRate(Map<Rank, Integer> lottoResult, int purchaseAmount) {
        double returnRate = 0;

        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            int totalCount = lottoResult.get(rank);
            int prizeMoney = rank.getPrizeMoney();
            returnRate += totalCount * prizeMoney;
        }
        returnRate = 100 * (returnRate / purchaseAmount);

        return returnRate;
    }
}
