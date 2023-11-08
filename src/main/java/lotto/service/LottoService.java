package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.UserLottos;
import lotto.domain.WinningLotto;

public class LottoService {
    private UserLottos userLottos;
    private WinningLotto winningLotto;

    public void buyLotto(int lottoAmount) {
        userLottos = new UserLottos(lottoAmount);
    }

    public int getLottoNumbers() {
        return userLottos.getLottoNumbers();
    }

    public Lotto getLotto(int index) {
        return userLottos.getLotto(index);
    }

    public void createWinningLotto(String winningNumber) {
        winningLotto = new WinningLotto(winningNumber);
    }

    public void addBonusNumber(String bonusNumber) {
        winningLotto.addBonusNumber(bonusNumber);
    }

    public double calculateRateOfReturn() {
        return userLottos.calculateRateOfReturn(userLottos.calculateWinnings());
    }

    public int getThreeWins() {
        return userLottos.getThreeWins();
    }

    public int getFourWins() {
        return userLottos.getFourWins();
    }

    public int getFiveWins() {
        return userLottos.getFiveWins();
    }

    public int getFiveAndBonusWins() {
        return userLottos.getFiveAndBonusWins();
    }

    public int getSixWins() {
        return userLottos.getSixWins();
    }

    public void countWinningNumber() {
        userLottos.countWinningNumber(winningLotto);
    }
}
