package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.exception.LottoGameException;
import lotto.service.LottoService;
import lotto.util.LottoUtil;
import lotto.util.Validate;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private static LottoGame lottoGame;

    public static void Lotto() {
        startGame();
        winningNumber();
        bonusNumber();
    }

    private static void startGame() {
        long purchaseAmount = 0L;
        while (purchaseAmount == 0) {
            try {
                purchaseAmount = Validate.checkPurchaseAmountValidate(InputView.getPurchaseAmount());
            } catch (LottoGameException e) {
                System.out.println(e.getMessage());
                purchaseAmount = 0L;
            }
        }
        lottoGame = new LottoGame(purchaseAmount);
        lottoGame.setLottos(getLottoNumbers(lottoGame.getLottoCnt()));
        OutputView.printLottos(lottoGame);
    }

    private static List<Lotto> getLottoNumbers(Long count) {
        return LottoService.getAllLottos(count);
    }


    private static void winningNumber() {
        Lotto winningNumber = null;
        while (winningNumber == null) {
            try {
                winningNumber = LottoUtil.convertList(InputView.getWinningNumber());
            } catch (LottoGameException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoGame.setWinningNumber(winningNumber);
    }

    private static void bonusNumber() {
        int bonusNumber = 0;
        bonusNumber = Validate.checkBonusNumberValidate(InputView.getBonusNumber());
        while (bonusNumber == 0) {
            try {
                bonusNumber = Validate.checkBonusNumberValidate(InputView.getBonusNumber());
            } catch (LottoGameException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoGame.setBonusNumber(bonusNumber);
    }
}
