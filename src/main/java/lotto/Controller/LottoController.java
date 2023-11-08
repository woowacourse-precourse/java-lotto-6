package lotto.Controller;

import static lotto.Global.Constants.LOTTO_NUMBER_AMOUNT;
import static lotto.Global.Constants.LOTTO_SALES_AMOUNT_MONEY;
import static lotto.Global.Exception.LOTTO_PURCHASE_INPUT;

import java.util.HashMap;
import java.util.List;
import lotto.Model.Lotto;
import lotto.Model.LottoMachine;
import lotto.View.View;

public class LottoController {

    private View view;
    private LottoMachine lottoMachine;

    public LottoController(View view, LottoMachine lottoMachine) {
        this.view = view;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        sellLotto();
        getWinningLottoInformation(getWinningLotto(), getBonusNumber());
        getTotalLottoResult();
    }

    private void sellLotto() {
        try {
            int lottoAmount = getLottoAmountByReceivedMoney();
            view.putLottoSellResult(lottoMachine.purchaseLottos(lottoAmount));
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            sellLotto();
        }
    }

    private int getLottoAmountByReceivedMoney() {
        try {
            int moneyAmount = view.getLottoBuyAmout();
            if (moneyAmount % LOTTO_SALES_AMOUNT_MONEY != 0) {
                throw new IllegalArgumentException(LOTTO_PURCHASE_INPUT.getErrorPhrase());
            }
            return moneyAmount / LOTTO_SALES_AMOUNT_MONEY;
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getLottoAmountByReceivedMoney();
        }
    }

    private void getWinningLottoInformation(Lotto winningLotto, int bonusNumber) {
        try {
            lottoMachine.setWinningNumberInformation(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            getWinningLottoInformation(winningLotto, getBonusNumber());
        }
    }

    private Lotto getWinningLotto() {
        try {
            List<Integer> winningNumber = view.getWinningLottoNumber(LOTTO_NUMBER_AMOUNT);
            return new Lotto(winningNumber);
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getWinningLotto();
        }
    }

    private int getBonusNumber() {
        try {
            int bonusNumber = view.getBonusLottoNumber();
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getBonusNumber();
        }
    }

    private void getTotalLottoResult() {
        HashMap<String, Integer> result = getLottoResult();
        view.putLottoResult(result, getRateOfResult(result));
    }

    private HashMap<String, Integer> getLottoResult() {
        try {
            HashMap<String, Integer> result = lottoMachine.getLottoWinningResult();
            return result;
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getLottoResult();
        }
    }

    private float getRateOfResult(HashMap<String, Integer> result) {
        try {
            float ratioOfResult = lottoMachine.getRateOfResult(result);
            return ratioOfResult;
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getRateOfResult(result);
        }
    }
}
