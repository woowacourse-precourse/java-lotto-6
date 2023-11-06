package service;

import static util.LottoUtil.*;

import domain.Lotto;
import domain.WinningLotto;

import VO.UserLottoVO;

public class LottoService {

    private final WinningLotto winningLotto;
    private final UserLottoVO userLottoVO;

    public LottoService(WinningLotto winningLotto, UserLottoVO userLottoVO) {
        this.winningLotto = winningLotto;
        this.userLottoVO = userLottoVO;
    }

    public int addPay(int pay) {
        userLottoVO.setPay(pay);
        return countLotto(pay);
    }

    public String addLotto(int count) {
        userLottoVO.setLottoList(makeLottoList(count));
        return userLottoVO.toString();
    }

    public void addWinningLotto(Lotto numbers) {
        winningLotto.setNumbers(numbers);
    }

    public void addBonusNumber(Integer bonusNumber) throws IllegalArgumentException {
        winningLotto.setBonusNumber(bonusNumber);
    }

    public int[] findWinResult() {
        return countWinLotto(winningLotto, userLottoVO);
    }

    public Double findRate(int[] winLottoArr) {
        return calculateRate(winLottoArr, userLottoVO.getPay());
    }

}
