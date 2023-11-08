package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumbersCreator;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;

public class GameService {
    private final NumbersCreator numbersCreator;
    private Lottos userLottos;
    Money purchaseMoney;

    public GameService(NumbersCreator numbersCreator) {
        this.numbersCreator = numbersCreator;
    }

    public List<List<Integer>> purchaseLottos(int purchaseMoney) {
        this.purchaseMoney = new Money(purchaseMoney);
        LottoMachine lottoMachine = new LottoMachine(numbersCreator);
        userLottos = lottoMachine.purchaseLotto(this.purchaseMoney);

        return userLottos.getLottos().stream()
                .map(Lotto::getSortedNumbers)
                .toList();
    }

    public WinningStatistics determineWinningStatistics(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusLottoNumber);
        return WinningStatistics.of(winningNumbers, userLottos);
    }

    public double getRateOfReturn(Money totalWinningMoney) {
        return totalWinningMoney.getRatio(purchaseMoney);
    }
}
