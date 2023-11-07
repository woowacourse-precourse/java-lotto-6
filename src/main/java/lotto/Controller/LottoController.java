package lotto.Controller;

import java.util.HashMap;
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
        getTotalLottoResult();
    }

    private void sellLotto() {
        try {
            int lottoAmount = getLottoAmountByReceivedMoney();
            view.putLottoSellResult(lottoMachine.buyLottos(lottoAmount));
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            sellLotto();
        }
    }

    private int getLottoAmountByReceivedMoney() {
        try {
            int moneyAmount = view.getLottoBuyAmout();
            if (moneyAmount % LOTTO_SALES_AMOUNT_MONEY != 0) {
                throw new IllegalArgumentException(Exception.LOTTO_PURCHASE_INPUT.getErrorPhrase());
            }
            return moneyAmount / LOTTO_SALES_AMOUNT_MONEY;
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getLottoAmountByReceivedMoney();
        }
    }

    private void getWinningLottoInformation() {
        List<Integer> winningNumber = getWinningNumber();
        int bonusNumber = getBonusNumber();
        lottoMachine.setWinningNumberInformation(winningNumber, bonusNumber);
    }

    private List<Integer> getWinningNumber() {
        try {
            List<Integer> winningNumber = view.getWinningLottoNumber(LOTTO_NUMBER_AMOUNT);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            view.printErrorMessage(e.getMessage());
            return getWinningNumber();
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
            HashMap<String, Integer> result = lottoMachine.getResult();
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
