package lotto;

import java.util.List;
import lotto.view.BonusNumberInputView;
import lotto.view.LottoPurchaseInputView;
import lotto.view.WinningNumbersInputView;

public class GameController {
    public void init() {
        // 로또 구입 금액을 입력 받는다.
        int purchaseAmount = LottoPurchaseInputView.getLottoPurchaseAmount();
        // 당첨 번호를 입력 받는다.
        List<Integer> winningNumbers = WinningNumbersInputView.getWinningNumbers();
        // 보너스 번호를 입력 받는다.
        int bonusNumber = BonusNumberInputView.getBonusNumber();
        
    }
}
