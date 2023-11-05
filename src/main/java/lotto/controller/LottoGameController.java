package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.Results;
import lotto.domain.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView = new InputView();

    public void run() {

        String purchaseAmount = inputView.inputPurchaseAmount();

        int userMoney = parseStringToUnsignedInt(purchaseAmount);

        Tickets tickets = Tickets.of(userMoney);

        OutputView.printPurchaseNumber(tickets.getNumberTickets());

        List<Lotto> asdf = IntStream.range(0, tickets.getNumberTickets())
            .mapToObj(i -> Lotto.generateRandomLottoNumbers())
            .toList();

        Lottos lottos = Lottos.of(asdf);

        lottos.getLottos().stream()
            .map(Lotto::toString)
            .forEach(System.out::println);

        String winningNumber = inputView.inputWinningNumber();

        List<Integer> winningNumbers = Arrays.stream(winningNumber.split(","))
            .map(Integer::parseInt)
            .toList();

        Lotto userLottoNumbers = Lotto.of(winningNumbers);

        String bonusNumber = inputView.inputBonusNumber();

        int bonusNumberInt = parseStringToUnsignedInt(bonusNumber);

        boolean isBonusNumber = userLottoNumbers.getMatchBonus(bonusNumberInt);

        Result[] results = Result.getAllLottoResult(lottos, userLottoNumbers, isBonusNumber);

        OutputView.printWinningStatistics(results);

        double profitRate = Result.getProfitRate(results, userMoney);

        OutputView.printProfitRate(profitRate);


    }

    private int parseStringToUnsignedInt(String input) {
        try {
            return Integer.parseUnsignedInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("0이상의 숫자만 입력가능합니다");
        }
    }

}
