package lotto.service;

import lotto.model.StatInfo;

import java.util.*;

public class Calculator {

    static final int UNIT = 1000;
    static final int PERCENTAGE = 100;
    public int calculateNumberOfLotto(int amount) {
        return amount / 1000;
    }

    public int countMatchedPairs(List<Integer> lotto, List<Integer> winningNumbers) {
        int sum = 0;
        for (Integer winningNumber : winningNumbers) {
            sum += Collections.frequency(lotto, winningNumber);
        }
        return sum;
    }

    public List<Integer> saveResult(List<List<Integer>> lottoStorage, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0));
        for (List<Integer> lotto : lottoStorage) {
            int num = countMatchedPairs(lotto, winningNumbers);
            if (num == 5 && lotto.contains(bonusNumber)) {
                result.set(7, result.get(7) + 1);
                continue;
            }
            result.set(num, result.get(num) + 1);
        }
        return result;
    }

    public double calculateRateOfReturn(int numberOfLotto, List<Integer> result) {
        int totalSpend = numberOfLotto * UNIT;
        int totalPrize = 0;
        totalPrize += StatInfo.THREE_MATCHED.getPrize() * result.get(3);
        totalPrize += StatInfo.FOUR_MATCHED.getPrize() * result.get(4);
        totalPrize += StatInfo.FIVE_MATCHED.getPrize() * result.get(5);
        totalPrize += StatInfo.FIVE_AND_BONUS_MATCHED.getPrize() * result.get(7);
        totalPrize += StatInfo.SIX_MATCHED.getPrize() * result.get(6);
        return (double) totalPrize / totalSpend * PERCENTAGE;
    }
}
