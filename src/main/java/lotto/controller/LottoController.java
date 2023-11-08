package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.util.MatchType;
import lotto.util.UiVO;

public class LottoController {

    private static LottoService lottoService = new LottoServiceImpl();

    public int receivePurchaseAmount() {

        UiVO.printPurchaseAmountInputText();
        int purchaseAmount = lottoService.inputPurchaseAmount();

        return purchaseAmount;
    }

    public int getPurchaseCount(int purchaseAmount) {

        int lottoCount = lottoService.calculatePurchaseCount(purchaseAmount);

        UiVO.printBoughtLottoCnt(lottoCount);

        return lottoCount;
    }

    public List<Lotto> generateLottos(int lottoCount) {

        List<Lotto> lottos = lottoService.generateLottos(lottoCount);
        UiVO.printLottos(lottos);

        return lottos;
    }

    public List<Integer> receiveWinningNumbers() {

        UiVO.printWinningNumberInputText();
        List<Integer> winningNumbers = lottoService.inputWinningNumbers();

        return winningNumbers;
    }

    public int receiveBonusNumber(List<Integer> winningNumbers) {

        UiVO.printBonusNumberInputText();
        int bonusNumber = lottoService.inputBonusNumber(winningNumbers);

        return bonusNumber;
    }

    public Map<MatchType, Integer> getWinningStatistics(List<Lotto> lottos,
                                                        List<Integer> winningNumbers,
                                                        int bonusNumber) {
        Map<MatchType, Integer> winningStatistics =
                lottoService.calculateWinningStatistics(lottos, winningNumbers, bonusNumber);

        UiVO.printWinningStatistics(winningStatistics);

        return winningStatistics;
    }

    public int getEarnings(Map<MatchType, Integer> winningStatistics) {

        int earnings = lottoService.calculateEarnings(winningStatistics);
        return earnings;
    }

    public double getReturnRate(int purchaseAmount, int earnings) {
        double returnRate = lottoService.calculateReturnRate(purchaseAmount, earnings);
        UiVO.printReturnRate(returnRate);

        return returnRate;
    }
}
