package lotto.Model;

import java.util.List;

public class CheckWinNumber {
    private final int MAX = 6;
    private final int BONUS = 5;

    public int checkWinNumber(List<Integer> autoTicket, List<Integer> winNumbers, int bonusNumber) {
        int cnt = 0;

        for (int i = 0; i < MAX; i++) {
            int winNumber = winNumbers.get(i);
            cnt += compareNumber(autoTicket, winNumber);

            if (cnt == BONUS)
                cnt = checkBonus(autoTicket, bonusNumber, cnt);
        }

        return cnt;
    }

    public int compareNumber(List<Integer> autoTicket, int winNumber) {
        int cnt = 0;
        for (int i = 0; i < MAX; i++) {
            if (autoTicket.get(i) == winNumber) {
                cnt++;
            }
        }
        return cnt;
    }

    public int checkBonus(List<Integer> autoTicket, int bonusNumber, int cnt) {
        for (int i = 0; i < MAX; i++) {
            if (autoTicket.get(i) == bonusNumber) {
                cnt++;
                cnt++;
            }

        }
        return cnt;
    }
}
