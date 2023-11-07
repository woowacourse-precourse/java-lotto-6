package lotto.service;

import lotto.domain.*;

import java.util.List;

public class LottoService {
    private WinningNumbers winningNumbers;
    private LottoBuyer lottoBuyer;

    public void buyLotto(Money money) {
        LottoMarket lottoMarket = new LottoMarket(new RandomNumbersGenerator());
        List<Lotto> lottos = lottoMarket.sellLotto(money);
        lottoBuyer = new LottoBuyer(lottos);
    }

    public List<Lotto> findBoughtLottos() {
        return lottoBuyer.getLottos();
    }

    public void setWiningNumbers(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        winningNumbers.addBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
    }

    public void compareAllLotto() {
        LottoCompare lottoCompare = new LottoCompare();
        lottoCompare.compareAllLottoToWinning(findLottos(), winningNumbers);
    public EnumMap<WinningGrade, Integer> getWinningResult() {
        return lottoCompare.getWinningResult();
    }

    public double calculateLottoYield() {
        LottoYieldStatistics lottoYieldStatistics = new LottoYieldStatistics();
        return lottoYieldStatistics.calculate(getPaidMoney(), getWinningResult());
    }

    private Money getPaidMoney() {
        return lottoBuyer.getPaidMoney();
    }
}