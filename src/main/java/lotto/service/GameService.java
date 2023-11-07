package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumbersCreator;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResult;
import lotto.domain.winning.WinningStatistics;

public class GameService {
    private final NumbersCreator numbersCreator;
    private Lottos userLottos;

    public GameService(NumbersCreator numbersCreator) {
        this.numbersCreator = numbersCreator;
    }

    public List<List<Integer>> purchaseLottos(int purchaseMoney) {
        LottoMachine lottoMachine = new LottoMachine(numbersCreator);
        userLottos = lottoMachine.purchaseLotto(new Money(purchaseMoney));

        return userLottos.getLottos().stream()
                .map(Lotto::getSortedNumbers)
                .toList();
    }

    public Map<WinningResult, Integer> determineWinningStatistics(List<Integer> drawNumbers, int bonusNumber) {
        WinningNumbers winningNumbers = createWinningNumbers(drawNumbers, bonusNumber);
        WinningStatistics statistics = WinningStatistics.of(winningNumbers, userLottos);

        return statistics.getStatistics();
    }

    private WinningNumbers createWinningNumbers(List<Integer> drawNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(drawNumbers);
        LottoNumber bonusLottoNumber = LottoNumber.valueOf(bonusNumber);

        return new WinningNumbers(winningLotto, bonusLottoNumber);
    }
}
