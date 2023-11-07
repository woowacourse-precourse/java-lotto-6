import Board.LottoOutcome;
import WinningNumber.WinningNumber;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static LottoOutcome calLottoOutcome(WinningNumber winningNumber, Lotto lotto){
        int numbersMatch = calNumbers(lotto.getNumbers(), winningNumber.getNumbers());
        int bonusMatch = calBonusNumber(lotto.getNumbers(), winningNumber.getBonusNum());
        return LottoOutcome.getFromNumOfMatchAndBonus(numbersMatch, bonusMatch);
    }

    public static Integer calNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        List<Integer> lottoCopy = new ArrayList<>(lottoNumbers);
        lottoCopy.retainAll(winningNumbers);
        return lottoCopy.size();
    }

    public static Integer calBonusNumber(List<Integer> lottoNumbers, Integer bonusNum){
        if(lottoNumbers.contains(bonusNum))
            return 1;
        return 0;
    }
}
