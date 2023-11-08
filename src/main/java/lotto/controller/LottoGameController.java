package lotto.controller;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.model.Wallet;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    Wallet wallet;
    User user = new User();
    WinningLotto winningLotto;

    public void start() {
        checkPurchaseAmount();
        buyLottoes();
        checkWinningLottoNumbers();
        printLottoesResult();
    }

    private void checkPurchaseAmount() {
        boolean isSuccess = false;
        while (!isSuccess) {
            try {
                OutputView.printInputPurchaseAmountMessage();
                wallet = new Wallet(InputView.getUserInput());
                isSuccess = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private void buyLottoes() {
        while (wallet.canBuyLotto()) {
            wallet.buyLotto();
            user.pickLottoNumber();
        }
        OutputView.printPurchaseLottoesMessage(user.getLottoes());
    }

    private void checkWinningLottoNumbers() {
        String lottoNumber = checkLottoNumber();
        String bonusNumber = checkBonusNumber(lottoNumber);
        winningLotto = new WinningLotto(lottoNumber, bonusNumber);
    }


    private String checkLottoNumber() {
        while (true) {
            try {
                OutputView.printInputWinningLottoNumberMessage();
                String lottoNumber = InputView.getUserInput();
                Lotto lotto = new Lotto(lottoNumber);
                return lottoNumber;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private String checkBonusNumber(String lottoNumber) {
        while (true) {
            try {
                OutputView.printInputWinningBonusNumberMessage();
                String bonusNumber = InputView.getUserInput();
                WinningLotto winningLotto = new WinningLotto(lottoNumber, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private void printLottoesResult() {
        Map<Integer, Integer> lottoesResult = user.checkLottoesRanking(winningLotto);
        OutputView.printLottoesResult(lottoesResult);
        long profit = wallet.calculateProfit(lottoesResult);
        double profitRate = wallet.calculateProfitRate(profit);
        OutputView.printProfitRate(setDoubleWithCommas(profitRate));
    }

    private String setDoubleWithCommas(double number) {
        DecimalFormat formatter = new DecimalFormat("#,##0.0");
        return formatter.format(number);
    }
}
