package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGameController {


    private String inputLottoPurchaseAmount;
    private int lottoPurchaseAmount;
    private int lottoQuantity;
    private List<Lotto> lotto;
    private String inputLottoWinningNumber;
    private List<Integer> winningNumber;
    private String inputBonusNumber;
    private int bonusNumber;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    public void gameStart(){
        inputPurchaseAmount();
        inputWinningNumber();
        inputBonusNumber();
        lottoWinningResult();
    }

    private void inputPurchaseAmount(){
        boolean isPurchaseAmountValidation = false;

        while (!isPurchaseAmountValidation){
            inputLottoPurchaseAmount = inputView.inputPurchaseAmount();
            isPurchaseAmountValidation = lottoGameService.inputPurchaseAmountValidation(inputLottoPurchaseAmount);
        }
        lottoPurchaseAmount = Integer.parseInt(inputLottoPurchaseAmount);

        lottoQuantity = lottoGameService.lottoQuantity(lottoPurchaseAmount);
        lotto = lottoGameService.createLotto(lottoQuantity);
        outputView.purchaseLottoNumbersDisplay(lotto);
    }

    private void inputWinningNumber(){
        boolean isWinningNumberValidation = false;

        while (!isWinningNumberValidation){
            inputLottoWinningNumber = inputView.inputWinningNumber();
            isWinningNumberValidation = lottoGameService.inputWinningNumberValidation(inputLottoWinningNumber);
        }
        winningNumber = lottoGameService.createWinningNumber(inputLottoWinningNumber);
    }

    private void inputBonusNumber(){
        boolean isBonusNumberValidation = false;

        while (!isBonusNumberValidation){
            inputBonusNumber = inputView.inputBonusNumber();
            isBonusNumberValidation = lottoGameService.inputBonusNumberValidation(inputBonusNumber);
        }
        bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    private void lottoWinningResult(){
        Map<String, String> lottoWinningResult = lottoGameService.lottoWinningResultCalculation(lotto, winningNumber, bonusNumber);
        outputView.lottoResultDisplay(lottoWinningResult);
    }

}
