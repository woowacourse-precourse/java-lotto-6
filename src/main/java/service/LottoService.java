package service;

import VO.UserLottoVO;
import domain.WinningLotto;

public class LottoService {

    private final WinningLotto winningLotto;
    private final UserLottoVO userLottoVO;

    public LottoService(WinningLotto winningLotto, UserLottoVO userLottoVO) {
        this.winningLotto = winningLotto;
        this.userLottoVO = userLottoVO;
    }
}
