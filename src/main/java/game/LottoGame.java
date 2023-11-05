package game;

import base.Converter;
import java.util.ArrayList;
import java.util.List;
import lotteryProfit.OutputResult;
import lotteryProfit.ProfitCalculator;
import lottoResult.LottoResultDisplay;
import lottoResult.UserLottoNumbers;
import lottoTicketPurchase.LottoTicketPurchase;
import lottoTicketPurchase.LottoTicketQuantity;
import lottoWinningNumber.BonusNumberInput;
import lottoWinningNumber.WinningNumberInput;

public class LottoGame {
    public void run() {
        Converter converter = new Converter();
        LottoTicketPurchase lottoTicketPurchase = new LottoTicketPurchase();
        LottoTicketQuantity lottoTicketQuantity = new LottoTicketQuantity();
        UserLottoNumbers lottoTicketDisplay = new UserLottoNumbers();
        WinningNumberInput winningNumberInput = new WinningNumberInput();
        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        LottoResultDisplay lottoResultDisplay = new LottoResultDisplay();
        ProfitCalculator profitCalculator = new ProfitCalculator();
        int purchaseAmount = lottoTicketPurchase.getPurchaseAmount(converter);

        // LottoTicketPurchase

        System.out.println();

        //LottoTicketQuantity

        int purchaseQuantity = lottoTicketQuantity.getPurchaseQuantity(purchaseAmount);

        lottoTicketQuantity.printPurchaseQuantity(purchaseQuantity);

        //UserLottoNumbers
        List<List<Integer>> userLottoNumbers = lottoTicketDisplay.getUserLottoNumbers(purchaseQuantity);
        lottoTicketDisplay.printUserLottoNumbers(purchaseQuantity, userLottoNumbers);

        System.out.println();

        //WinningNumberInput

        List<Integer> winningNumberList = new ArrayList<>();

        String winningNumbers = winningNumberInput.receiveWinningNumbers();
        String[] winningNumberStringList = winningNumberInput.makeWinningNumberStringList(winningNumbers, converter);
        winningNumberInput.getWinningNumbers(winningNumberStringList, winningNumberList, converter);

        //BonusNumberInput
        System.out.println();

        int bonusNumber = bonusNumberInput.getBonusNumber(converter);

        System.out.println();

        // LottoResultDisplay
        lottoResultDisplay.getLottoSuccessCount(userLottoNumbers, winningNumberList, bonusNumber);
        lottoResultDisplay.outputLottoResult();

        // LotteryProfit
        OutputResult outputResult = new OutputResult();
        outputResult.outputProfitResult(profitCalculator, lottoResultDisplay, purchaseAmount);
    }
}