package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.LottoIssuer;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.message.Error;
import lotto.message.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private static final double TO_PERCENTAGE = 100.0;

    private final LottoIssuer lottoIssuer = new LottoIssuer();

    public void play() {
        Lottos lottos = getLottos();
        WinningNumber winningNumber = getWinningNumber();
        final int bonusNumber = getBonusNumber(winningNumber);

        Map<LottoResult, Integer> result = lottos.getResult(winningNumber, bonusNumber);
        double yieldRate = getYieldRate(result, lottos.getPurchaseQuantity());
        OutputView.printGameResult(result, yieldRate);
    }

    private double getYieldRate(Map<LottoResult, Integer> result, int purchaseQuantity) {
        int purchasePrice = purchaseQuantity * LOTTO_PRICE;
        int totalYield = getTotalYield(result);

        return TO_PERCENTAGE * totalYield / purchasePrice;
    }

    private int getTotalYield(Map<LottoResult, Integer> result) {
        int totalYield = 0;

        Set<LottoResult> keys = result.keySet();
        for (LottoResult lottoResult : keys) {
            Integer count = result.get(lottoResult);
            totalYield += lottoResult.yield(count);
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
}
