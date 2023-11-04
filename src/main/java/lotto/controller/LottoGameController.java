package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Tickets;
import lotto.domain.UserNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView = new InputView();

    public void run() {

        String purchaseAmount = inputView.inputPurchaseAmount();

        int userMoney = parseStringToUnsignedInt(purchaseAmount);

        Tickets tickets = Tickets.of(userMoney);

        OutputView.printPurchaseNumber(tickets.getNumberTickets());

        //
        Lottos lottos = Lottos.of(tickets.getNumberTickets());

        lottos.getLottos().stream()
            .map(Lotto::toString)
            .forEach(System.out::println);

        String winningNumber = inputView.inputWinningNumber();
        UserNumbers userNumbers = UserNumbers.of(winningNumber);

        String bonusNumber = inputView.inputBonusNumber();
        UserNumbers bonus = UserNumbers.of(bonusNumber);

//        Result result = Result.getLottoResult(lottos, userNumbers, bonus);
//
//        outputView.printWinningStatistics();
//
//        result.

    }

    private int parseStringToUnsignedInt(String input) {
        try {
            return Integer.parseUnsignedInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("0이상의 숫자만 입력가능합니다");
        }
    }

}
