package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constants;
import lotto.Prize;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static int quantity;
    private static int value = 0;
    private static int cost = 0;
    private static int prize = 0;
    private static int sixSame = 0;
    private static int fiveBonus = 0;
    private static int fiveSame = 0;
    private static int fourSame = 0;
    private static int threeSame = 0;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
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
        }
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


    public void calculatePrize() {
        Prize prizeInit = Prize.ZERO;
        prize += prizeInit.multiplyAndAdd(sixSame, Prize.FIRST.getPrizeAmount());
        prize += prizeInit.multiplyAndAdd(fiveBonus, Prize.SECOND.getPrizeAmount());
        prize += prizeInit.multiplyAndAdd(fiveSame, Prize.THIRD.getPrizeAmount());
        prize += prizeInit.multiplyAndAdd(fourSame, Prize.FOURTH.getPrizeAmount());
        prize += prizeInit.multiplyAndAdd(threeSame, Prize.FIFTH.getPrizeAmount());
    }

    public void calculateCost() {
        cost += quantity * Constants.COST;
    }

    public void calculateReturn() {
        value = (prize/cost) * 100;
    }
}
