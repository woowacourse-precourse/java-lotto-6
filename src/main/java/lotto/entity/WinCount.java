package lotto.entity;

import java.util.List;

public class WinCount {
    private static int calculateWinCount(List<Integer> userNumbers, List<Integer> winNumbers, int bonusNumber) {
        int count = 0;
        if (userNumbers.containsAll(winNumbers)) {return 7;}
        for (int number : userNumbers) {
            if (winNumbers.contains(number)) {
                count++;
                // 5개 번호가 일치하고 보너스 번호까지 일치하는 경우
                if (count == 5 && userNumbers.contains(bonusNumber)) {
                    return 6;
                }
            }
        }
        return count;
    }
}
