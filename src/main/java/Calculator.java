import Board.LottoOutcome;
import WinningNumber.WinningNumber;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static LottoOutcome calLottoOutcome(WinningNumber winningNumber, Lotto lotto){

    }

    public static Integer calNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        List<Integer> lottoCopy = new ArrayList<>(lottoNumbers);
        lottoCopy.retainAll(winningNumbers);
        return lottoCopy.size();
    }
}
