package game;

import base.Converter;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lottoProfit.ProfitCalculator;
import lottoProfit.ProfitResultDisplay;
import lottoResult.LottoResultDisplay;
import lottoTicketPurchase.LottoTicketPurchase;
import lottoTicketPurchase.LottoTicketQuantity;
import lottoTicketPurchase.UserLottoNumbers;
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
        ProfitResultDisplay outputResult = new ProfitResultDisplay();

        int purchaseAmount = lottoTicketPurchase.getPurchaseAmount();

        System.out.println();

        int purchaseQuantity = lottoTicketQuantity.getPurchaseQuantity(purchaseAmount);

        lottoTicketQuantity.printPurchaseQuantity(purchaseQuantity);

        List<List<Integer>> userLottoNumbers = lottoTicketDisplay.getUserLottoNumbers(purchaseQuantity);
        lottoTicketDisplay.printUserLottoNumbers(purchaseQuantity, userLottoNumbers);

        System.out.println();

        List<Integer> winningNumberList = new ArrayList<>();

        String winningNumbers = winningNumberInput.receiveWinningNumbers();
        String[] winningNumberStringList = winningNumberInput.makeWinningNumberStringList(winningNumbers, converter);
        winningNumberInput.getWinningNumbers(winningNumberStringList, winningNumberList, converter);

        Lotto lotto = new Lotto(winningNumberList);

        System.out.println();

        int bonusNumber = bonusNumberInput.getBonusNumber(converter);

        System.out.println();

        lottoResultDisplay.outputLottoResultNotice();
        lottoResultDisplay.getLottoSuccessCount(userLottoNumbers, winningNumberList, bonusNumber);
        lottoResultDisplay.outputLottoResult();

        outputResult.outputProfitResult(profitCalculator, lottoResultDisplay, purchaseAmount);
        Console.close();
    }
}