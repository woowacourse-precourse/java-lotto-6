package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validate(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                System.out.println(numbers.get(i) + "]");
            } else if (i != numbers.size() - 1){
                if (i == 0) {
                    System.out.print("[");
                }
                System.out.print(numbers.get(i) + ", ");
            }
        }
    }

    public void inspectBouns(int num) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == num) {
                throw new IllegalArgumentException("[ERROR] IllegalArgumentException");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int equalBounsCount(int num) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == num) {
                return 1;
            }
        }
        return 0;
    }

    static public int equalCount(Lotto lotto1, Lotto lotto2) {
        List<Integer> arr1 = lotto1.getNumbers();
        List<Integer> arr2 = lotto2.getNumbers();
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr1.get(i) == arr2.get(j)) {
                    count++;
                }
            }
        }
        switch (count) {
            case 3:
                return Result.THREE_MATCH.ordinal();
            case 4:
                return Result.FOUR_MATCH.ordinal();
            case 5:
                if (lotto1.equalBounsCount(lotto2.getNumbers().get(6)) == 1) {
                    return Result.FIVE_MATCH_BONUS.ordinal();
                } else {
                    return Result.FIVE_MATCH.ordinal();
                }
            case 6:
                return Result.SIX_MATCH.ordinal();
            default:
                return Result.NONE.ordinal();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] IllegalArgumentException");
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1) {
                throw new IllegalArgumentException("[ERROR] IllegalArgumentException");
            }
            for (int j = 0; j < numbers.size(); j++) {
                if (i == j) continue;
                if (numbers.get(i) == numbers.get(j)) {
                    throw new IllegalArgumentException("[ERROR] IllegalArgumentException");
                }
            }
        }
    }
}

