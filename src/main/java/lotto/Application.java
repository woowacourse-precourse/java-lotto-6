package lotto;

import java.util.Set;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);

        int purchaseAmount = lottoPurchase.requestPurchaseAmount();
        lottoMachine.printLottoTickets(lottoMachine.issueLottoTickets(purchaseAmount));

        LottoWinningNumberInput lottoWinningNumberInput = new LottoWinningNumberInput();
        Set<Integer> winningNumbers = lottoWinningNumberInput.requestLottoWinningNumbers();

    }
}
