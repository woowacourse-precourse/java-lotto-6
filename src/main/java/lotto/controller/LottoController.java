package lotto.controller;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.LottoIssuer;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.message.Error;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {


    private final LottoIssuer lottoIssuer = new LottoIssuer();

    public void play() {
        Lottos lottos = getLottos();
        WinningNumber winningNumber = getWinningNumber();
        final int bonusNumber = getBonusNumber(winningNumber);

        GameResult gameResult = lottos.getResult(winningNumber, bonusNumber);
        OutputView.printGameResult(gameResult.getWinningCount(), gameResult.getYieldRate(lottos.getPurchaseQuantity()));
    }

    private int getBonusNumber(WinningNumber winningNumber) {
        try {
            int bonusNumber = InputView.getBonusNumber();
            if (hasDuplicate(bonusNumber, winningNumber.getNumbers())) {
                throw new IllegalArgumentException(Error.DUPLICATE_NUMBER_EXIST.getMessage());
            }
            System.out.println();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumber);
        }
    }

    private WinningNumber getWinningNumber() {
        try {
            List<Integer> numbers = InputView.getWinningNumbers();
            System.out.println();
            return new WinningNumber(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private Lottos getLottos() {
        System.out.println();
        try {
            Lottos lottos = lottoIssuer.buy(InputView.getPrice());
            OutputView.printIssueResults(lottos);
            System.out.println();
            return lottos;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottos();
        }
    }

    private boolean hasDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        return winningNumbers.contains(bonusNumber);
    }
}
