package lotto.controller;

import java.util.List;
import lotto.domain.LottoSet;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.LottoView;

public class LottoController {
    private static final String BONUS_NUMBER_DUPLICATED_ERROR = "보너스 숫자는 당첨 번호와 중복될 수 없습니다";

    private final LottoService lottoService;
    private LottoView lottoView = new LottoView();

    public LottoController() {
        Money money = lottoView.getLottoPurchase();
        LottoSet lottoSet = LottoSet.generateRandomLottoSetSizeWith(money.getLottoCount());
        List<Integer> winningNumbers = lottoView.getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        lottoService = new LottoService(lottoSet, winningNumbers, bonusNumber);
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
