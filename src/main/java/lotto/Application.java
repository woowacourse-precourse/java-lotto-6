package lotto;

import domain.LottoGame.CalculateResult;
import domain.LottoTicket.LottoTicket;
import domain.LottoGame.LottoGameResult;
import domain.WinningNumbers;
import domain.LottoTicket.PaymentCalculator;
import ui.input.NumbersInput;
import ui.input.PurchaseAmount;
import ui.output.PrintResult;
import ui.output.PurchasedLottos;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = PurchaseAmount.getPurchaseAmount();
        List<LottoTicket> lottoTickets = PaymentCalculator.purchaseLottoTickets(purchaseAmount);
        PurchasedLottos.printPurchasedLottos(lottoTickets);

        WinningNumbers winningNumbers = NumbersInput.getWinningNumbers();
        LottoGameResult result = CalculateResult.calculateResult(lottoTickets, winningNumbers);

        PrintResult.printResult(result);
    }
}

