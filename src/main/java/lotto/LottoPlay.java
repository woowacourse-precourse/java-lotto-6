package lotto;

import java.util.List;
import lotto.constant.Rank;
import lotto.controller.LottoMachine;
import lotto.controller.PurchaseMachine;
import lotto.controller.ResultMachine;
import lotto.model.Lotto;
import lotto.model.WinningLottoDTO;

public class LottoPlay implements Play{
    private final PurchaseMachine purchaseMachine = new PurchaseMachine();
    private final LottoMachine lottoMachine = new LottoMachine();
    private final ResultMachine resultMachine = new ResultMachine();

    @Override
    public void start() {
        List<Lotto> myLotto = purchase();
        WinningLottoDTO winningLotto = lottery();
        checkResult(myLotto, winningLotto);
    }

    @Override
    public List<Lotto> purchase() {
        int purchaseQuantity;
        purchaseQuantity = purchaseMachine.getPurchaseQuantity();
        return purchaseMachine.getMyLottoNumber(purchaseQuantity);
    }

    @Override
    public WinningLottoDTO lottery() {
        Lotto winningLotto = lottoMachine.readWinningNumber();
        int bonusNumber = lottoMachine.readBonusNumber(winningLotto);
        return new WinningLottoDTO(winningLotto, bonusNumber);
    }

    @Override
    public void checkResult(List<Lotto> myLotto, WinningLottoDTO winningLotto) {
        Rank[] ranks = resultMachine.getWinningStat(myLotto, winningLotto);
        resultMachine.printWinningStat(ranks);
        resultMachine.printYieldRate(myLotto.size(), ranks);
    }
}
