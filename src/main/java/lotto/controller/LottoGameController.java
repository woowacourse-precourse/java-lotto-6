package lotto.controller;

import lotto.domain.Lotto;
import lotto.model.LottoNumberModel;
import lotto.model.LottoResultModel;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoGameController {

    private int lottoPurchaseAmount;
    private int bonusNumber;
    private int lottoQuantity;
    private List<Integer> winningNumber;
    private List<Lotto> lotto;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoGameService lottoGameService = new LottoGameService();

    public void gameStart(){
        inputPurchaseAmount();
        createLotto();
        lottoNumbersDisplayModelAndView();
        inputWinningNumber();
        inputBonusNumber();
        lottoWinningResultModelAndView();
    }

    private void inputPurchaseAmount(){
        boolean isPurchaseAmountValidation = false;
        String inputLottoPurchaseAmount = "";

        while (!isPurchaseAmountValidation){
            inputLottoPurchaseAmount = inputView.inputPurchaseAmount();
            isPurchaseAmountValidation = lottoGameService.inputPurchaseAmountValidation(inputLottoPurchaseAmount);
        }

        lottoPurchaseAmount = Integer.parseInt(inputLottoPurchaseAmount);
    }

    private void createLotto(){
        lottoQuantity = lottoGameService.lottoQuantity(lottoPurchaseAmount);
        lotto = lottoGameService.createLotto(lottoQuantity);
    }

    private void lottoNumbersDisplayModelAndView(){
        LottoNumberModel lottoNumberModel = createLottoNumberModel(lotto);
        outputView.purchaseLottoNumbersDisplay(lottoNumberModel);
    }

    private void inputWinningNumber(){
        boolean isWinningNumberValidation = false;
        String inputLottoWinningNumber = "";

        while (!isWinningNumberValidation){
            inputLottoWinningNumber = inputView.inputWinningNumber();
            isWinningNumberValidation = lottoGameService.inputWinningNumberValidation(inputLottoWinningNumber);
        }

        winningNumber = lottoGameService.createWinningNumber(inputLottoWinningNumber);
    }

    private void inputBonusNumber(){
        boolean isBonusNumberValidation = false;
        String inputBonusNumber = "";

        while (!isBonusNumberValidation){
            inputBonusNumber = inputView.inputBonusNumber();
            isBonusNumberValidation = lottoGameService.inputBonusNumberValidation(winningNumber,inputBonusNumber);
        }
        bonusNumber = Integer.parseInt(inputBonusNumber);
    }

    private void lottoWinningResultModelAndView(){
        LottoResultModel lottoResultModel = lottoGameService.lottoWinningResultCalculation(lotto, winningNumber, bonusNumber);
        outputView.lottoResultDisplay(lottoResultModel);
    }

    private LottoNumberModel createLottoNumberModel(List<Lotto> lotto){
        LottoNumberModel lottoNumberModel = new LottoNumberModel(lotto);
        return lottoNumberModel;
    }

}
