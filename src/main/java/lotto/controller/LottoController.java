package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.WinningNumber;
import lotto.message.ErrorMessage;
import lotto.view.InputView;

public class LottoController {

    private LottoIssuer lottoIssuer = new LottoIssuer();

    public void play() {
        List<Lotto> lottos = getLottos();
        WinningNumber winningNumber = getWinningNumber();
        final int bonusNumber = getBonusNumber(winningNumber);
        // TODO - 이후 기능 구현
    }

    private int getBonusNumber(WinningNumber winningNumber) {
        try {
            int bonusNumber = InputView.getBonusNumber();
            if (hasDuplicate(bonusNumber, winningNumber.getNumbers())) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_EXIST.getMessage());
            }
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumber);
        }
    }

    private boolean hasDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        return winningNumbers.contains(bonusNumber);
    }

    private WinningNumber getWinningNumber() {
        try {
            return InputView.getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private List<Lotto> getLottos() {
        try {
            return lottoIssuer.buy(InputView.getPrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottos();
        }
    }


}
