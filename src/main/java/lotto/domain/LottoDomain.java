package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.LottoConstants;

import java.util.List;

public class LottoDomain {

    public Lottos createLottos(int purchaseCount) {
        Lotto lotto;
        Lottos lottos = new Lottos();

        for (int i = 0; i < purchaseCount; i++) {
            lotto = createLotto();
            lottos.addLotto(lotto);
        }

        return lottos;
    }

    public WinningNumbers createWinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber, bonusNumber);

        return winningNumbers;
    }


    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_NUMBER_MIN, LottoConstants.LOTTO_NUMBER_MAX, LottoConstants.LOTTO_NUMBER_COUNT);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
