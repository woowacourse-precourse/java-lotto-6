package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum WinningGrade {
    THIRD(3, "3개 일치 (5,000원)"),
    FOURTH(4, "4개 일치 (50,000원)"),
    FIFTH(5, "5개 일치 (1,500,000원)"),
    FIFTH_BONUS(7, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIXTH(6, "6개 일치 (2,000,000,000원)");

    private final int count;
    private final String description;

    WinningGrade(int count, String description) {
        this.count = count;
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }
}

public class Winner {

    private List<Integer> result = new ArrayList<>(Collections.nCopies(8, 0));


    public void checkLottoNumbers(List<Integer> userLotto, List<Integer> winnerLotto, int bonus) {
        int rightCount = 0;
        for (int number : userLotto) {
            if (winnerLotto.contains(number)) {
                rightCount++;
            }
        }
        boolean bonusMaching = userLotto.contains(bonus);

        if (rightCount == 5) {
            if (bonusMaching) {
                result.set(WinningGrade.FIFTH_BONUS.getCount(), result.get(WinningGrade.FIFTH_BONUS.getCount()) + 1);
            }
            if (!bonusMaching) {
                result.set(rightCount, result.get(rightCount) + 1);
            }
        }
        if (rightCount != 5) {
            result.set(rightCount, result.get(rightCount) + 1);
        }

    }

    public List<Integer> getResult() {
        return this.result;
    }

    public void printLottoResult(List<Integer> result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for (WinningGrade grade : WinningGrade.values()) {
            System.out.println(grade.getDescription() + " - " + result.get(grade.getCount()) + "개");
        }

    }
}


