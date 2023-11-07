package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.LottoConstants;
import lotto.view.OutputView;
import lotto.view.viewArgument.LottoPrizeMoney;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoDomain {
    OutputView outputView;
    LottoPrizeMoney lottoPrizeMoney;

    public LottoDomain(OutputView outputView) {
        this.outputView = outputView;
    }

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

            if (checkWin(result)) {
                lottoStats.put(result, lottoStats.get(result) + 1);
            }
        }

        return lottoStats;
    }

    public double printLottoStats(Map<String, Integer> resultStats, int purchaseCount) {
        double purchaseAmount = (double) (purchaseCount * LottoConstants.DIVISION_THOUSAND);
        int earningMoney = 0;

        for (Entry<String, Integer> entrySet : resultStats.entrySet()) {
            outputView.printWinningDetail(entrySet.getKey(), entrySet.getValue());
            earningMoney += getMoney(entrySet.getKey()) * entrySet.getValue();
        }

        return (earningMoney / purchaseAmount) * 100;
    }

    private boolean checkWin(String result) {
        if (result.equals("-1")) {
            return false;
        }
        return true;
    }
    private int getMoney(String correctCount) {
        LottoPrizeMoney prizeMoney = lottoPrizeMoney.valueOfCorrectCount(correctCount);
        return prizeMoney.getPrizeMoney();
    }

    private Map<String, Integer> createLottoStats() {
        Map<String, Integer> lottoStats = new LinkedHashMap<>();

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
