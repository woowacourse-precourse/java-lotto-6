package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumber {
    private List<Integer> winningNumberWithBonusNumber;
    private int bonusNumber;

    public List<Integer> getWinningNumberWithBonusNumber() {
        return winningNumberWithBonusNumber;
    }

    public List<RankTable> matchLottoCalculate(List<Lotto> lottos) {
        List<RankTable> matchLottoCalculate = new ArrayList<>();

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumber = lotto.getNumbers();
            int matchCount = countMatchNumber(lottoNumber);
            RankTable rankTable = RankTable.filterBonusNumber(lottoNumber, bonusNumber, matchCount);
            matchLottoCalculate.add(rankTable);
        }
        return matchLottoCalculate;
    }

    private int countMatchNumber(List<Integer> lottoNumber) {
        int matchCount = 0;

        for (Integer winningNumber : winningNumberWithBonusNumber) {
            if (lottoNumber.contains(winningNumber)) {
                ++matchCount;
            }
        }
        return matchCount;
    }


    public void setWinningNumberWithBonusNumber(List<Integer> winningNumberWithBonusNumber) {
        this.winningNumberWithBonusNumber = winningNumberWithBonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
