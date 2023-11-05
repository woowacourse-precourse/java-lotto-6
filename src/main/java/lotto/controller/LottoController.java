package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoIssuer;
import lotto.domain.WinningNumber;
import lotto.message.Error;
import lotto.message.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private LottoIssuer lottoIssuer = new LottoIssuer();

    public void play() {
        LottoGame lottoGame;

        List<Lotto> lottos = getLottos();
        WinningNumber winningNumber = getWinningNumber();
        final int bonusNumber = getBonusNumber(winningNumber);
        lottoGame = new LottoGame(lottos, winningNumber, bonusNumber);
        Map<LottoResult, Integer> result = lottoGame.getResult();
        OutputView.printGameResult(result, getYieldRate(result, lottos.size()));
    }

    private double getYieldRate(Map<LottoResult, Integer> result, int purchaseQuantity) {
        int purchasePrice = purchaseQuantity * 1000;
        int totalYield = getTotalYield(result);

        return ((double) totalYield) / purchasePrice * 100;
    }

    private int getTotalYield(Map<LottoResult, Integer> result) {
        int totalYield = 0;

        Set<LottoResult> keys = result.keySet();
        for (LottoResult lottoResult : keys) {
            totalYield += lottoResult.yield(result.get(lottoResult));
        }
        return totalYield;
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

    private boolean hasDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        return winningNumbers.contains(bonusNumber);
    }

    private WinningNumber getWinningNumber() {
        try {
            WinningNumber winningNumber = InputView.getWinningNumbers();
            System.out.println();
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    private List<Lotto> getLottos() {
        System.out.println();
        try {
            List<Lotto> lottos = lottoIssuer.buy(InputView.getPrice());
            System.out.println();
            return lottos;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottos();
        }
    }
}
