package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Referee;
import lotto.model.WinningLotto;
import lotto.view.OutputView;

public class LottoController {
    private final MoneyValidator moneyValidator;
    private final NumberValidator numberValidator;
    private final OutputView outputView;
    private final Referee referee;

    public LottoController(final Referee referee) {
        this.moneyValidator = MoneyValidator.getInstance();
        this.numberValidator = NumberValidator.getInstance();
        this.outputView = OutputView.getInstance();
        this.referee = referee;
    }

    public int inputPurchaseMoney() {
        String input;
        do {
            input = Console.readLine();
        } while (moneyValidator.validateMoneyInput(input));
        return Integer.parseInt(input);
    }

    public List<Integer> inputWinningLottoNumbers() {
        String input;
        do {
            input = Console.readLine().trim();
        } while (numberValidator.validateWinningNumbers(input));

        final List<String> splitInput = List.of(input.split(","));
        return splitInput.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public int inputWinningLottoBonusNumber(final List<Integer> winningNumbers) {
        String input;
        do {
            input = Console.readLine();
        } while (numberValidator.validateWinningBonusNumber(winningNumbers, input));
        return Integer.parseInt(input);
    }

    public void getLottoResult(final List<Lotto> lottos, final WinningLotto winningLotto) {
        referee.judge(lottos, winningLotto);

        final double rateOfReturn = referee.getRateOfReturn(lottos.size() * 1000);
        outputView.printResult(referee, rateOfReturn);
    }
}