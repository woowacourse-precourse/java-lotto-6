package lotto.constant;

import java.util.Arrays;
import java.util.List;

public enum RottoResult {
    FIVE(5, 3, 5_000),
    FOUR(4, 4, 50_000),
    THREE(3, 5, 1_500_000),
    TWO(2, 7, 30_000_000),
    ONE(1, 6, 2_000_000_000);

    private final int matchingNumber;
    private final int amout;
    private final int index;

    RottoResult(int index, int matchingNumber, int amout) {
        this.matchingNumber = matchingNumber;
        this.amout = amout;
        this.index = index;
    }

    private int getMatchingNumber() {
        return matchingNumber;
    }

    private int getAmout() {
        return amout;
    }

    private int getIndex() {
        return index;
    }

    private static int getAmout(int index) {
        return Arrays.stream(RottoResult.values())
                .filter(rottoResult -> rottoResult.getIndex() == index)
                .findAny().get().getAmout();
    }

    public static int getIndex(int num) {
        return Arrays.stream(RottoResult.values())
                .filter(rottoResult -> rottoResult.getMatchingNumber() == num)
                .findFirst().get().getIndex();
    }

    public static double calculateAmout(List<Integer> numbers) {
        double sum = 0;
        for(int i = 1; i<6; i++){
            sum += getAmout(i) * numbers.get(i);
        }
        return sum;
    }
}
