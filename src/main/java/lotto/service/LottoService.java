package lotto.service;

import lotto.Lotto;
import lotto.domain.*;
import lotto.domain.lotto.*;
import lotto.domain.winning.WinningGrade;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningResultMapper;

import java.util.List;
import java.util.Map;

public class LottoService {
    private WinningNumbers winningNumbers;
    private LottoBuyer lottoBuyer;
    private LottoCompare lottoCompare;

    public void buyLotto(Money money) {
        LottoMarket lottoMarket = new LottoMarket(new RandomNumbersGenerator());
        List<Lotto> lottos = lottoMarket.sellLotto(money);
        lottoBuyer = new LottoBuyer(lottos, money);
    }

    public List<List<Integer>> findBoughtLottos() {
        return lottoBuyer.getLottos().stream().map(Lotto::getSortedNumbers).toList();
    }

    public void setWiningNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        winningNumbers.addBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
    }

    public void compareAllLotto() {
        lottoCompare = new LottoCompare();
        lottoCompare.compareAllLottoToWinning(findBoughtLottos(), winningNumbers);
    }

    public double calculateLottoYield() {
        LottoYieldStatistics lottoYieldStatistics = new LottoYieldStatistics();
        return lottoYieldStatistics.calculate(getPaidMoney(), getWinningResult());
    }

    public List<String> getWinningResultMap() {
        Map<WinningGrade, Integer> winningResult = lottoCompare.getWinningResult();
        WinningResultMapper mapper = new WinningResultMapper();
        return mapper.drawWinningResultMap(winningResult);
    }

    private Map<WinningGrade, Integer> getWinningResult() {
        return lottoCompare.getWinningResult();
    }

    private Money getPaidMoney() {
        return lottoBuyer.getPaidMoney();
    }
}