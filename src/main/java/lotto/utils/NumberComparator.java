package lotto.utils;


import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinNumber;

import java.util.List;

public class NumberComparator {

    private NumberComparator() {
    }

    public static Prize compare(Lotto lotto, WinNumber winNumber) {
        int matchedCount = lotto.getNumber().stream()
                .mapToInt(lottoNumber -> countMatches(lotto.getNumber(), winNumber.getPickNumbers()))
                .sum();
        boolean checkBonus = checkBonus(matchedCount, lotto.getNumber(), winNumber);
        return Prize.valueOf(matchedCount, checkBonus);
    }

    private static boolean checkBonus(int matchedCount, List<Integer> lottoNumber, WinNumber winNumber) {
        return matchedCount == 5 && lottoNumber.contains(winNumber.getBonusNumber());
    }

    private static int countMatches(List<Integer> lottoNumber, List<Integer> winNumbers) {
        return (int) lottoNumber.stream()
                .filter(winNumbers::contains)
                .count();
    }
}
