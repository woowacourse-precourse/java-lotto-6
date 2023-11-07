package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.LottoConstants;
import lotto.view.viewArgument.LottoPrizeMoney;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Integer> compareNumbers(Lottos lottos, WinningNumbers winningNumbers) {
        Map<String, Integer> lottoStats = createLottoStats();

        for (int i = 0; i < lottos.getLottosSize(); i++) {
            Lotto lotto = lottos.getLotto(i);
            String result = lotto.lottoResult(winningNumbers.getNumbers(), winningNumbers.getBonusNumber());

            lottoStats.put(result, lottoStats.get(result) + 1);
        }

        return lottoStats;
    }



    private Map<String, Integer> createLottoStats() {
        Map<String, Integer> lottoStats = new HashMap<>();

        for (LottoPrizeMoney lottoPrizeMoney : LottoPrizeMoney.values()) {
            lottoStats.put(lottoPrizeMoney.getCorrectCount(), 0);
        }
        return lottoStats;
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_NUMBER_MIN, LottoConstants.LOTTO_NUMBER_MAX, LottoConstants.LOTTO_NUMBER_COUNT);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }
}
