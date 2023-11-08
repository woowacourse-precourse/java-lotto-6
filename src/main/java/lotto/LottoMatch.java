package lotto;

import java.util.Collections;
import java.util.List;

public class LottoMatch {
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int fiveWithBonusCount;
    private int sixMatchCount;

    public LottoMatch() {
        this.threeMatchCount = 0;
        this.fourMatchCount = 0;
        this.fiveMatchCount = 0;
        this.fiveWithBonusCount = 0;
        this.sixMatchCount = 0;
    }

    public void checkLotto(List<Integer> randomLottoNumbers, List<Integer> winningLottoNumbers, int bonusNumber) {
        Collections.sort(randomLottoNumbers);
        Collections.sort(winningLottoNumbers);

        int matchCount = 0;
        for (int i = 0; i < randomLottoNumbers.size(); i++) {
            if (randomLottoNumbers.get(i).equals(winningLottoNumbers.get(i))) {
                matchCount++;
            }
        }

        if (matchCount == 3) {
            threeMatchCount++;
            return;
        }
        if (matchCount == 4) {
            fourMatchCount++;
            return;
        }
        if (matchCount == 5) {
            if (winningLottoNumbers.contains(bonusNumber)) {
                fiveWithBonusCount++;
                return;
            }
            fiveMatchCount++;
            return;
        }
        if (matchCount == 6) {
            sixMatchCount++;
            return;
        }
    }
    public void printResult() {
        System.out.println("3개 일치 (5,000원) - " + threeMatchCount + "개");
        System.out.println("4개 일치 (50,000원) - " + fourMatchCount + "개");
        System.out.println("5개 일치 (1,500,000원) - " + fiveMatchCount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveWithBonusCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatchCount + "개");
    }
}
