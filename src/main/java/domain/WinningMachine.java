package domain;

import constant.Rank;

import java.util.List;

public class WinningMachine {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    public WinningMachine(Lotto winningNumbers, BonusNumber bonusNumber){
        this.winningLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
    public Rank getWinningRank(Lotto lotto){
        List<Integer> winningNumbers =  winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        int correctCount = 0;

        // 당첨 숫자들과 비교
        for(int number : lottoNumbers){
            if(winningNumbers.contains(number))
                correctCount++;
        }

        // 보너스 번호 비교
        boolean isBonus = lottoNumbers.contains(bonusNumber.getNumber());
        return  Rank.getRank(correctCount, isBonus);
    }
}
