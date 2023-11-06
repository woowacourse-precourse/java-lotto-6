package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoManager;
import lotto.model.Referee;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoManager lottoManager;
    private final Validator validator;
    private final InputView inputView;
    private final OutputView outputView;
    private final Referee referee;

    public LottoController(final Referee referee) {
        this.validator = new Validator();
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.lottoManager = inputPurchaseMoney();
        this.referee = referee;
    }

    public LottoManager inputPurchaseMoney() {
        String input;
        do {
            input = Console.readLine();
        } while (validator.validateMoneyInput(input));
        final int money = Integer.parseInt(input);
        final LottoManager lottoManager = new LottoManager(money);
        outputView.printCreateLottoNumbers(lottoManager.getLottos());
        return lottoManager;
    }

    public void createWinningLotto() {
        final List<Integer> winningNumbers = inputWinningLottoNumbers();
        final int bonusNumber = inputWinningLottoBonusNumber(winningNumbers);
        final WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        lottoManager.setWinningLotto(winningLotto);
    }

    public void getLottoResult() {
        final List<Lotto> lottos = lottoManager.getLottos();
        final WinningLotto winningLotto = lottoManager.getWinningLotto();
        referee.judge(lottos, winningLotto);

        final double rateOfReturn = referee.getRateOfReturn(lottos.size() * 1000);
        outputView.printResult(referee, rateOfReturn);
    }

    private List<Integer> inputWinningLottoNumbers() {
        List<Integer> winningNumbers;
        do {
            final String inputNumbers = Console.readLine().trim();
            final List<String> splitInput = List.of(inputNumbers.split(","));
            winningNumbers = splitInput.stream()
                    .map(Integer::parseInt)
                    .toList();
        } while (validator.validateWinningNumbers(winningNumbers));
        return winningNumbers;
    }

    private int inputWinningLottoBonusNumber(final List<Integer> winningNumbers) {
        inputView.printWinningBonusNumberMessage();
        String input;
        do {
            input = Console.readLine();
        } while (validator.validateWinningBonusNumber(winningNumbers, input));
        return Integer.parseInt(input);
    }
}