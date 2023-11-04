package service;

import static util.LottoUtil.*;

import VO.UserLottoVO;
import domain.WinningLotto;

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
}
