package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Purchace {
    private static int times;
    protected static List<List<Integer>> lottoes;

    public Purchace(int times) {
        this.times = times;
        this.lottoes = allPurchase();
    }

    public enum MatchType {
        THREE("3개 일치 (5,000원) - ", 3),
        FOUR("4개 일치 (50,000원) - ", 4),
        FIVE("5개 일치 (1,500,000원) - ", 5),
        BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 7),
        SIX("6개 일치 (2,000,000,000원) - ", 6);

        private final String money;
        private final int value;

        private MatchType(String money, int value) {
            this.money = money;
            this.value = value;
        }

        public String getMoney() {
            return this.money;
        }

        public int getValue() {
            return this.value;
        }
    }

    private static List<List<Integer>> allPurchase() {
        List<List<Integer>> purchaseLottoes = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            purchaseLottoes.add(eachPurchase());
        }
        printLottoNumbers(purchaseLottoes);
        return purchaseLottoes;
    }

    private static List<Integer> eachPurchase() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    private static void printLottoNumbers(List<List<Integer>> purchaseLottoes) {
        System.out.println(times + "개를 구입했습니다.");
        for (int i = 0; i < times; i++) {
            System.out.println(purchaseLottoes.get(i));
        }
        System.out.println();
    }

    protected static void analysisStatistic(WinLotto winLotto) {
        HashMap<Integer, Integer> statistic = new HashMap<>();
        for (MatchType match : MatchType.values()) {
            statistic.put(match.value, 0);
        }
        statistic = analysisWinningStatistic(winLotto, statistic);

        printStatistic(statistic);
    }

    private static HashMap<Integer, Integer> analysisWinningStatistic(WinLotto winLotto, HashMap<Integer, Integer> statistic) {
        for (int i = 0; i < times; i++) {
            int duplicateNumber = winLotto.lotto.analysisLottoStatistic(lottoes.get(i));
            statistic.put(duplicateNumber, statistic.getOrDefault(duplicateNumber, 0) + 1);

            if (duplicateNumber == MatchType.FIVE.value) {
                statistic = analysisBonusStatistic(lottoes.get(i), statistic, winLotto.bonus.bonus);
            }
        }
        return statistic;
    }

    private static HashMap<Integer, Integer> analysisBonusStatistic(List<Integer> lotto, HashMap<Integer, Integer> statistic, int bonus) {
        boolean bonusCheck = lotto.stream().anyMatch(num -> num == bonus);
        if (bonusCheck) {
            statistic.put(MatchType.BONUS.value, statistic.getOrDefault(MatchType.BONUS.value, 0) + 1);
            statistic.put(MatchType.FIVE.value, statistic.getOrDefault(MatchType.FIVE.value, 0) - 1);
        }
        return statistic;
    }

    private static void printStatistic(HashMap<Integer, Integer> statistic) {
        System.out.println("당첨 통계\n---");
        for (MatchType match : MatchType.values()) {
            System.out.println(match.money + statistic.get(match.value) + "개");
        }
    }
}
