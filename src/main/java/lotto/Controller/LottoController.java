package lotto.Controller;

import java.util.List;
import lotto.Global.Exception;
import lotto.Model.LottoMachine;
import lotto.View.View;

public class LottoController {

    private View view;
    private LottoMachine lottoMachine;
    public static int LOTTO_SALES_AMOUNT_MONEY = 1000;
    public static int LOTTO_NUMBER_AMOUNT = 6;


    public LottoController(View view, LottoMachine lottoMachine) {
        this.view = view;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        sellLotto();
        getWinningLottoInformation();
        getLottoResult();
    }

    private void sellLotto() {
        int lottoAmount = getLottoAmountByReceivedMoney();
        view.putLottoSellResult(lottoMachine.buyLottos(lottoAmount));
    }

    private int getLottoAmountByReceivedMoney() {
        int moneyAmount = view.getLottoBuyAmout();
        if (moneyAmount % LOTTO_SALES_AMOUNT_MONEY != 0) {
            throw new IllegalArgumentException(Exception.LOTTO_PURCHASE_INPUT.getErrorPhrase());
        }
        return moneyAmount / LOTTO_SALES_AMOUNT_MONEY;
    }

    private void getWinningLottoInformation() {
        List<Integer> winningNumber = view.getWinningLottoNumber(LOTTO_NUMBER_AMOUNT);
        int bonusNumber = view.getBonusLottoNumber();
        lottoMachine.setWinningNumberInformation(winningNumber, bonusNumber);
    }

    private void getLottoResult() {
        view.putLottoResult(lottoMachine.getResult());
    }
}
