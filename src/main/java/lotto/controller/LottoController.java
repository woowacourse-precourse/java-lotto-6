package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {
    private static final String BONUS_NUMBER_DUPLICATED_ERROR = "보너스 숫자는 당첨 번호와 중복될 수 없습니다";

    private final LottoService lottoService = new LottoService();
    private final LottoView lottoView = new LottoView();

    public void purchaseLottos() {
        Money money = lottoView.getLottoPurchase();
        LottoList lottoList = LottoList.generateRandomLottoSetSizeWith(money.getLottoCount());
        printPublishedLottos(money.getLottoCount(), lottoList.getLottos());
        List<Integer> winningNumbers = lottoView.getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        printStatistics(lottoList, winningNumbers, bonusNumber);
        calculateRateOfReturn(lottoList, winningNumbers, bonusNumber);
        printRateOfReturn(lottoList, winningNumbers, bonusNumber);
    }

    private void printStatistics(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        lottoView.printWinningStatistics(lottoService.compareLottos(lottoList, winningNumbers, bonusNumber));
    }

    private void printPublishedLottos(int lottoCount, List<Lotto> lottos) {
        lottoView.printPublishedLottos(lottoCount, lottos);
    }

    private void printRateOfReturn(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        lottoView.printRateOfReturn(calculateRateOfReturn(lottoList, winningNumbers, bonusNumber));
    }

    private double calculateRateOfReturn(LottoList lottoList, List<Integer> winningNumbers, int bonusNumber) {
        return lottoService.calculateRateOfReturn(lottoList, winningNumbers, bonusNumber);
    }

    private boolean winningNumbersContainsBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        return winningNumbers.contains(bonusNumber);
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        do {
            bonusNumber = lottoView.getBonusNumber();
            if (winningNumbersContainsBonusNumber(winningNumbers, bonusNumber)) {
                System.out.println(LottoView.ERROR + BONUS_NUMBER_DUPLICATED_ERROR);
                bonusNumber = 0;
            }
        } while(bonusNumber == 0);

        return bonusNumber;
    }

}
