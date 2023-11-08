package lotto.controller;

import lotto.globalconstatnt.LottoRank;
import lotto.domain.Lotto;
import lotto.model.LottoNumberModel;
import lotto.model.LottoResultModel;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.util.List;


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
        LottoResultModel lottoResultModel = createLottoResultModel(lotto,winningNumber,bonusNumber);
        outputView.lottoResultDisplay(lottoResultModel);
    }

    private LottoResultModel createLottoResultModel(List<Lotto> lotto , List<Integer> winningNumber, int bonusNumber){
        List<LottoRank> lottoRanks = lottoGameService.lottoWinningResult(lotto,winningNumber,bonusNumber);
        BigDecimal totalReturnRate = lottoGameService.totalReturnRateCalculation(lottoRanks);
        int threeMatch = 0;
        int fourMatch = 0;
        int fiveMatch = 0;
        int fiveBonusMatch = 0;
        int sixMatch = 0;

        for(LottoRank lottoRank : lottoRanks){
            if(lottoRank.getRank()==1) sixMatch++;
            if(lottoRank.getRank()==2) fiveBonusMatch++;
            if(lottoRank.getRank()==3) fiveMatch++;
            if(lottoRank.getRank()==4) fourMatch++;
            if(lottoRank.getRank()==5) threeMatch++;
        }
        return new LottoResultModel(totalReturnRate.toString(),String.valueOf(threeMatch),String.valueOf(fourMatch),String.valueOf(fiveMatch),String.valueOf(fiveBonusMatch),String.valueOf(sixMatch));
    }

    private LottoNumberModel createLottoNumberModel(List<Lotto> lotto){
        return new LottoNumberModel(lotto);
    }
}
