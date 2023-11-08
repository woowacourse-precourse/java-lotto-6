package lotto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.view.InputHandler;
import lotto.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount = InputHandler.inputPurchaseAmount();
        OutputHandler.outputPurchaseAmount(amount);
        List<List<Integer>> userLottoList = LottoTickets.makeLottoNums(amount);
        List<Integer> winningNums = InputHandler.inputWinningNumber();
        Lotto lotto = new Lotto(winningNums);
        int bonusNum = InputHandler.inputBonusNum(winningNums);
        winningNums.add(bonusNum);

        // 당첨 결과 출력
        OutputHandler.printWinningResult(userLottoList, winningNums);
    }

}
