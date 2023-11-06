package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {


    private String inputLottoPurchaseAmount;
    private int lottoPurchaseAmount;
    private int lottoQuantity;
    private String inputLottoWinningNumber;
    private List<Integer> winningNumber;
    private String inputBonusNumber;
    private int bonusNumber;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    public void gameStart(){
        boolean isPurchaseAmountValidation = false;
        boolean isWinningNumberValidation = false;
        boolean isBonusNumberValidation = false;

        while (!isPurchaseAmountValidation){
            inputLottoPurchaseAmount = inputView.inputPurchaseAmount();
            isPurchaseAmountValidation = lottoGameService.inputPurchaseAmountValidation(inputLottoPurchaseAmount);
        }
        lottoPurchaseAmount = Integer.parseInt(inputLottoPurchaseAmount);

        lottoQuantity = lottoGameService.lottoQuantity(lottoPurchaseAmount);
        List<Lotto> lotto = lottoGameService.createLotto(lottoQuantity);
        outputView.purchaseLottoNumbersDisplay(lotto);

        while (!isWinningNumberValidation){
            inputLottoWinningNumber = inputView.inputWinningNumber();
            isWinningNumberValidation = lottoGameService.inputWinningNumberValidation(inputLottoWinningNumber);
        }
        winningNumber = lottoGameService.createWinningNumber(inputLottoWinningNumber);

        while (!isBonusNumberValidation){
            inputBonusNumber = inputView.inputBonusNumber();
            isBonusNumberValidation = lottoGameService.inputBonusNumberValidation(inputBonusNumber);
        }
        bonusNumber = Integer.parseInt(inputBonusNumber);

        outputView.lottoWinningResultDisplay(lotto,winningNumber,bonusNumber);
    }

}
