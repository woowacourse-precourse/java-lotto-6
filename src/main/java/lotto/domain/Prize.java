package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Prize {
    private static HashMap<String, Integer> prizeRecords = new HashMap<>();

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

    private static int compare(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        lottoNumbers.retainAll(winningNumbers);
        int containingCount = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                containingCount++;
            }
        }
        return containingCount;
    }

    public HashMap<String, Integer> compareAllLottoTickets(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        HashMap<String, Integer> prizeCountsRecords = createPrizeCountsRecords();
        int matchCount;
        boolean needToCheckBonus;
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = lotto.getNumbers();
            matchCount = compare(numbers, winningNumbers);
            needToCheckBonus = checkNeedBonus(matchCount, bonusNumber, numbers);
            String placeType = returnPrizeType(matchCount, needToCheckBonus);
            int previousCount = prizeCountsRecords.get(placeType);
            prizeCountsRecords.put(placeType, previousCount + 1);
        }
        return prizeCountsRecords;
    }

    private static boolean checkNeedBonus(int matchCount, int bonusNumber, List<Integer> numbers) {
        return matchCount == 5 && numbers.contains(bonusNumber);
    }

    public HashMap<String, Integer> createPrizeCountsRecords() {
        prizeRecords.put("firstPlace", 0);
        prizeRecords.put("secondPlace", 0);
        prizeRecords.put("thirdPlace", 0);
        prizeRecords.put("fourthPlace", 0);
        prizeRecords.put("fifthPlace", 0);
        prizeRecords.put("noPlace", 0);
        return prizeRecords;
    }

    private static String returnPrizeType(int matchCount, boolean needToCheckBonus) {
        for (PrizeType prizeType : PrizeType.values()) {
            if (matchCount == 5) {
                return checkSecondOrThirdPlace(matchCount, needToCheckBonus);
            }
            if (matchCount == prizeType.match) {
                return prizeType.place;
            }
        }
        return "noPlace";
    }

    private static String checkSecondOrThirdPlace(int matchCount, boolean needToCheckBonus) {
        String placeType = "noPlace";
        if (needToCheckBonus && matchCount == 5) {
            placeType = "secondPlace";
        }
        if (!needToCheckBonus && matchCount == 5) {
            placeType = "thirdPlace";
        }
        return placeType;
    }

    public void printResults(HashMap<String, Integer> prizeCountsRecords) {
        PrizeType[] prizeTypeValues = PrizeType.values();
        for (int i = prizeTypeValues.length - 1; i >= 0; i--) {
            PrizeType current = prizeTypeValues[i];
            if (current.place.equals("secondPlace")) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", current.match, current.rewards, prizeCountsRecords.get(current.place));
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", current.match, current.rewards, prizeCountsRecords.get(current.place));
        }
    }

}
