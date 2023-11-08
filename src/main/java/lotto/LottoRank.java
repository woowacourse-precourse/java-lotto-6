package lotto;

import java.util.List;

public class LottoRank {

    public static int isRank(Lotto lotto, Lotto compare, int bonusNum) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> compareNumbers = compare.getNumbers();
        int matchingCount = countMatchingNumbers(lottoNumbers, compareNumbers);
        boolean hasNum = isHasNum(compareNumbers, bonusNum);
        switch (matchingCount) {
            case 0, 1, 2 -> {
                return 6;
            }
            case 3 -> {
                return 5;
            }
            case 4 -> {
                return 4;
            }
            case 5 -> {
                if (!hasNum) {
                    return 3;
                } else {
                    return 2;
                }
            }
            case 6 -> {
                return 1;
            }
        }
        return -1;
    }

    private static int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> compareNumbers) {
        long count = lottoNumbers.stream()
                .filter(compareNumbers::contains)
                .count();
        return (int) count;
    }

    private static boolean isHasNum(List<Integer> compareNumbers, int bonusNum) {
        boolean hasNum = compareNumbers.stream().anyMatch(n -> n == bonusNum);
        return hasNum;
    }
}
