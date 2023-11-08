package lotto.domain;

import lotto.util.Error;
import lotto.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Prize {
    static final int SECOND_CORRECT_COUNT = 5;
    private final List<Integer> prizeNumber;
    private final int bonusNumber;
    private final LinkedHashMap<Rank, Integer> rankCounts = new LinkedHashMap<>();

    public Prize(List<Integer> prizeNumber, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.prizeNumber = prizeNumber;
        initRanks();
    }

    public static List<Integer> makePrizeNumbers(String prizeNumber) {
        List<String> numbers = Utils.splitName(prizeNumber);
        List<Integer> prizeNumbers = new ArrayList<>();
        validateSize(numbers.size());
        for (String number : numbers) {
            int changeStringToNumber = Utils.changeStringToInt(number);
            validateRange(changeStringToNumber);
            prizeNumbers.add(changeStringToNumber);
        }
        return prizeNumbers;
    }

    private static void validateSize(int numbersSize) {
        if (numbersSize != Buyer.LOTTO_COUNT) {
            Error error = Error.NOT_LOTTO_COUNT;
            Utils.backFunction(error);
        }
    }

    private static void validateRange(int number) {
        if (number < Buyer.MIN_LOTTO_NUMBER
                || number > Buyer.MAX_LOTTO_NUMBER) {
            Error error = Error.MIN_MAX_ERROR;
            Utils.backFunction(error);
        }
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
