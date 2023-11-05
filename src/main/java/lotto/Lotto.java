package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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
        Set<Integer> numbersSet = new LinkedHashSet<>();
        for(int i = 0; i<numbers.size(); i++)
        {
            numbersSet.add(numbers.get(i));
        }
        if(numbersSet.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public static List<Integer> generateRandomLotto() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbers2 = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.addAll(numbers2);
        Collections.sort(numbers);
        return numbers;
    }
    private static boolean contains(List<Integer> array, int value) {
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    static int countMatchedNumbers(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = 0;
        for (int number : lotto) {
            if (contains(winningNumbers, number)) {
                count++;
            }
        }
        return count;
    }

    static boolean hasBonusNumber(List<Integer> lotto, int bonusNumber) {

        return contains(lotto, bonusNumber);
    }

    static int getPrize(int matchedNumbers, boolean hasBonusNumber) {
        if (matchedNumbers == 6) {
            return 1;
        }
        if (matchedNumbers == 5 && hasBonusNumber) {
            return 2;
        }
        if (matchedNumbers == 5) {
            return 3;
        }
        if (matchedNumbers == 4) {
            return 4;
        }
        if (matchedNumbers == 3) {
            return 5;
        }
        return 0;
    }

    static int getPrizeAmount(int prize) {
        if(prize == 3) return 1500000;
        if(prize == 4) return 50000;
        if(prize == 5) return 5000;
        if(prize == 2) return 30000000;
        if(prize == 1) return 2000000000;
        return 0;
    }

    static int correctRate(int rank){
        if(rank == 1) return 6;
        if(rank == 2 || rank == 3) return 5;
        if(rank == 4) return 4;
        if(rank == 5) return 3;
        return 0;

    }

    static double calculateTotalPrizeAmount(int[] results) {
        double totalAmount = 0;
        for (int i = 1; i <= 5; i++) {
            int prize = i;
            int prizeAmount = getPrizeAmount(prize);
            int count = results[i];
            totalAmount += prizeAmount * count;
        }
        return totalAmount;
    }
}
