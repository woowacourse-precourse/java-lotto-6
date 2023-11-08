package lotto;

import java.util.ArrayList;
import java.util.List;

//단순히 일치 개수만 비교하는 클래스
public class NumbersComparator {
    private int count;
    private List<Lotto> allLottoNumbers;
    private List<Integer> winningNumbers;
    private List<Integer> winningCount = new ArrayList<>();
    private List<Integer> bonusCount = new ArrayList<>();

    public NumbersComparator(List<Lotto> allLottoNumbers, List<Integer> winningNumbers) {
        this.allLottoNumbers = allLottoNumbers;
        this.winningNumbers = winningNumbers;

        compareNumber();
    }

    public void compareNumber () {
        for (int i=0; i<allLottoNumbers.size(); i++) {
            count=0;
            compareWinningNumbers(i);
            compareBonusNumber(i);
            winningCount.add(count);
        }
    }


    private void compareBonusNumber(int i) {
        if (count != 5) {
            return;
        }
        if (allLottoNumbers.get(i).getNumbers().contains(winningNumbers.get(7))) {
            //5개 일치, 보너스 볼 일치
            bonusCount.add(i, 1);
        }
    }

    private void compareWinningNumbers(int i) {
        for (int j=0; j<6; j++) {
            if (allLottoNumbers.get(i).getNumbers().contains(winningNumbers.get(j))) {
                count++;
            }
        }
    }

    public List<Integer> getWinningCount() {
        return winningCount;
    }

    public List<Integer> getBonusCount() {
        return bonusCount;
    }
}
