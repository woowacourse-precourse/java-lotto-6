package lotto;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputHandler.getValidPurchaseAmount();
        LottoGame game = new LottoGame(purchaseAmount);

        // Print purchased lotto tickets
        LottoTicketPrinter.printTickets(game.getLottos());

        // Calculate results
        LottoResultCalculator resultCalculator = new LottoResultCalculator();
        Map<Integer, Integer> results = resultCalculator.calculateResults(game.getLottos(), game.getWinningNumbers(), game.getBonusNumber());

        // Print results
        LottoRateOfReturnCalculator.printResults(results);

        // Calculate and print rate of return
        double rateOfReturn = LottoRateOfReturnCalculator.calculateRateOfReturn(results, purchaseAmount);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}






