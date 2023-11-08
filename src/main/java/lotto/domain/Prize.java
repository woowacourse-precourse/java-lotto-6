package lotto.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prize {

    enum PrizeType {
        FIRST_PLACE(6, "2,000,000,000", false, "firstPlace"),
        SECOND_PLACE(5, "30,000,000", true, "secondPlace"),
        THIRD_PLACE(5, "1,500,000", false, "thirdPlace"),
        FOURTH_PLACE(4, "50,000", false, "fourthPlace"),
        FIFTH_PLACE(3, "5,000", false, "fifthPlace");

        private final int match;
        private final String rewards;
        private final boolean needBonus;
        private final String place;

        PrizeType(int match, String rewards, boolean needBonus, String place) {
            this.match = match;
            this.rewards = rewards;
            this.needBonus = needBonus;
            this.place = place;
        }

        public int match() {
            return match;
        }

        public String rewards() {
            return rewards;
        }

        public int getRewardMoney() {
            String stringRewards = rewards.replace(",", "");
            int rewardMoney = Integer.parseInt(stringRewards);
            return rewardMoney;
        }

        public boolean isItNeedBonus() {
            return needBonus;
        }

        public String place() {
            return place;
        }
    }

    private static int compare(List<Integer> lotto, List<Integer> winningNumbers) {
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        Set<Integer> lottoSet = new HashSet<>(lotto);
        lottoSet.retainAll(winningNumbersSet);
        System.out.println(lottoSet);
        int matchCount = lottoSet.size();
        return matchCount;

    }

    public static HashMap<String, Integer> compareAllLottoTickets(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<String, Integer> prizeCountsRecords = createPrizeCountsRecords();
        int matchCount;
        boolean needToCheckBonus = false;
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.lottoNumbers();
            matchCount = compare(numbers, winningNumbers);
            if (matchCount == 5 && numbers.contains(bonusNumber)) {
                needToCheckBonus = true;
            }
            String placeType = returnPrizeType(matchCount, needToCheckBonus);
            int previousCount = prizeCountsRecords.get(placeType);
            prizeCountsRecords.put(placeType, previousCount + 1);
        }
        return prizeCountsRecords;
    }

    public static HashMap<String, Integer> createPrizeCountsRecords() {
        HashMap<String, Integer> prizeCountsRecords = new HashMap<>(5);
        prizeCountsRecords.put("firstPlace", 0);
        prizeCountsRecords.put("secondPlace", 0);
        prizeCountsRecords.put("thirdPlace", 0);
        prizeCountsRecords.put("fourthPlace", 0);
        prizeCountsRecords.put("fifthPlace", 0);
        prizeCountsRecords.put("noPlace", 0);
        return prizeCountsRecords;
    }

    public static String returnPrizeType(int matchCount, boolean needToCheckBonus) {
        for (PrizeType prizeType : PrizeType.values()) {
            if (matchCount == prizeType.match && needToCheckBonus == prizeType.needBonus) {
                return prizeType.place;
            }
        }
        return "noPlace";
    }

    public static void printResults(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<String, Integer> prizeCountsRecord = compareAllLottoTickets(lottoTickets, winningNumbers, bonusNumber);
        for (PrizeType p : PrizeType.values()) {
            System.out.printf(
                    "%d개 일치 (%s원) - %d개\n", p.match, p.rewards, prizeCountsRecord.get(p.place)
            );
        }
    }
}
