package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.util.SortedRandomNumberGenerator;
import lotto.view.InputView;

public class LottoGame {
    private final LottoGenerator lottoGenerator = new LottoGenerator(new SortedRandomNumberGenerator());

    public void play() {
        List<Lotto> lottos = issueLotto();
        Lotto winningNumber = getValidWinningLotto();
        int bonusNumber = getValidBonusNumber(winningNumber);
    }

    private List<Lotto> issueLotto() {
        try {
            return lottoGenerator.generateForAmount(InputView.getAmount());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return issueLotto();
        }
    }

    private Lotto getValidWinningLotto() {
        try {
            return WinningAndBonusNumberValidator.validateWinningNumber(InputView.getWinningNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return getValidWinningLotto();
        }
    }

    private int getValidBonusNumber(Lotto winningLotto) {
        try {
            return WinningAndBonusNumberValidator.validateBonusNumber(winningLotto.getNumbers(), InputView.getBonusNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return getValidBonusNumber(winningLotto);
        }
    }
}
