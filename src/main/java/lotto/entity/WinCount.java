package lotto.entity;

import java.util.List;

public class WinCount {
    public static int calculateWinCount(List<Integer> userNumbers, List<Integer> winNumbers, int bonusNumber) {
        int count = 0;
        if (userNumbers.containsAll(winNumbers)) {return 7;}
        for (int number : userNumbers) {
            if (winNumbers.contains(number)) {
                count++;
            }
            if (count == 5 && userNumbers.contains(bonusNumber)) {
                return 6;
            }
        }
        return count;
    }
}
