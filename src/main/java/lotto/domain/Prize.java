package lotto.domain;

import lotto.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Prize {
    int SECOND_CORRECT_COUNT = 5;
    private final List<Integer> prizeNumber;
    private final int bonusNumber;
    private final LinkedHashMap<Rank, Integer> rankCounts = new LinkedHashMap<>();


    public Prize(String prizeNumber, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.prizeNumber = makePrizeNumbers(prizeNumber);
        initRanks();
    }

    private List<Integer> makePrizeNumbers(String prizeNumber) {
        List<String> numbers = List.of(prizeNumber.split(","));
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String number : numbers) {
            prizeNumbers.add(Utils.changeStringToInt(number));
        }
        return prizeNumbers;
    }

    public HashMap<Rank, Integer> makePrizeRanks(Buyer buyer) {
        List<Lotto> Lotteries = buyer.getLotteries();
        for (Lotto lottery : Lotteries) {
            Rank rank = getRankObject(lottery);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        return rankCounts;
    }

    public Rank getRankObject(Lotto lotto) {
        List<Integer> compareNumbers = new ArrayList<>(prizeNumber);
        compareNumbers.retainAll(lotto.numbers);
        if (compareNumbers.size() == SECOND_CORRECT_COUNT && isContainBonusNumber(lotto.numbers)) {
            return Rank.SECOND;
        }
        return Rank.getRankByCount(compareNumbers.size());
    }

    public boolean isContainBonusNumber(List<Integer> lottoNumbers) {
        for (int number : lottoNumbers) {
            if (bonusNumber == number) {
                return true;
            }
        }
        return false;
    }

    private void initRanks() {
        rankCounts.put(Rank.FIFTH, 0);
        rankCounts.put(Rank.FOURTH, 0);
        rankCounts.put(Rank.THIRD, 0);
        rankCounts.put(Rank.SECOND, 0);
        rankCounts.put(Rank.FIRST, 0);
    }
}
