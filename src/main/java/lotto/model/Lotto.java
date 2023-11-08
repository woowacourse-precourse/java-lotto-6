package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;
import lotto.Prize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final int quantity = 0;
    private static double value = 0;
    private static double cost;
    public static int sixSame = 0;
    public static int fiveBonus = 0;
    public static int fiveSame = 0;
    public static int fourSame = 0;
    public static int threeSame = 0;

    public static int[] count;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public int[] getCount() {
        return count;
    }

    public double getValue() {
        return value;
    }

    public int compareWith(List<Integer> inputNumbers) {
        validate(inputNumbers);

        int matchCount = 0;
        for (Integer inputNumber : inputNumbers) {
            if (numbers.contains(inputNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int compareWithBonus(List<Integer> inputNumbers, int bonusNum) {
            int matchCount = compareWith(inputNumbers);
            if (matchCount == 6) {
                return 6;
            }

            if (matchCount == 5 && numbers.contains(bonusNum)) {
                return 5;
            }

            if (matchCount == 5) {
                return 4;
            }

            if (matchCount == 4) {
                return 3;
            }

            if (matchCount == 3) {
                return 2;
            }

            return 0;
    }

    public void getWinningData(List<List<Integer>> randomNumbers,int bonusNumber) {
            int num = 0;
            for (List<Integer> randomNumber : randomNumbers) {
                num = compareWithBonus(randomNumber, bonusNumber);

                if (num == 6) {
                    sixSame++;
                }
                if (num == 5) {
                    fiveBonus++;
                }
                if (num == 4) {
                    fiveSame++;
                }
                if (num == 3) {
                    fourSame++;
                }
                if (num == 2) {
                    threeSame++;
                }
            }
    }

    public double multiplyAndAdd(int multiplier, double addition) {
            return (multiplier * addition);
    }


    public double calculatePrize() {
            double prize = 0;
            prize += multiplyAndAdd(sixSame, Prize.FIRST.getPrizeAmount());
            prize += multiplyAndAdd(fiveBonus, Prize.SECOND.getPrizeAmount());
            prize += multiplyAndAdd(fiveSame, Prize.THIRD.getPrizeAmount());
            prize += multiplyAndAdd(fourSame, Prize.FOURTH.getPrizeAmount());
            prize += multiplyAndAdd(threeSame, Prize.FIFTH.getPrizeAmount());
            return prize;
    }

    public void calculateReturn() {
            if (cost == 0) {
                value = 0.0;
                return;
            }
            double totalPrize = calculatePrize();
            double returnRate = (totalPrize / cost) * 100;
            value = Math.round(returnRate * 10.0) / 10.0;
            if (Math.abs(value - (int) value) < 0.01) {
                value = Math.round(value);
            }

    }


    public void setCost(int ticketCost) {
        cost = ticketCost;
    }


    public void setWinningCount() {
        count = new int[5];
        count[0]=threeSame;
        count[1]=fourSame;
        count[2]=fiveSame;
        count[3]=fiveBonus;
        count[4]=sixSame;
    }
}
