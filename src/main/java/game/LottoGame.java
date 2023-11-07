package game;

import base.Converter;
import java.util.ArrayList;
import java.util.List;
import lottoProfit.OutputProfitResult;
import lottoProfit.ProfitCalculator;
import lottoResult.LottoResultDisplay;
import lottoResult.UserLottoNumbers;
import lottoTicketPurchase.LottoTicketPurchase;
import lottoTicketPurchase.LottoTicketQuantity;
import lottoWinningNumber.BonusNumberInput;
import lottoWinningNumber.Lotto;
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
        OutputProfitResult outputResult = new OutputProfitResult();

        // LottoTicketPurchase
        int purchaseAmount = lottoTicketPurchase.getPurchaseAmount();

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

        // Lotto클래스 검증용으로 활용
        Lotto lotto = new Lotto(winningNumberList);

        //BonusNumberInput
        System.out.println();

        int bonusNumber = bonusNumberInput.getBonusNumber(converter);

        System.out.println();

        // LottoResultDisplay
        lottoResultDisplay.outputLottoResultNotice();
        lottoResultDisplay.getLottoSuccessCount(userLottoNumbers, winningNumberList, bonusNumber);
        lottoResultDisplay.outputLottoResult();

        // LotteryProfit
        outputResult.outputProfitResult(profitCalculator, lottoResultDisplay, purchaseAmount);
    }
}