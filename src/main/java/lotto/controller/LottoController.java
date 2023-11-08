package lotto.controller;

import static lotto.validation.Validation.validateBonusNumber;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmount;
import lotto.model.Lottos;
import lotto.model.PrizeResult;
import lotto.model.WinningLotto;
import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Service service;
    private LottoAmount lottoAmount;

    private Lottos lottos;

    private WinningLotto winningLotto;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        service = new Service();
    }

    public void start() {
        int lottoTicketCount = inputLottoAmount();
        outputView.printLottoTicketCount(lottoTicketCount);

        lottos = createLottos(lottoTicketCount);
        outputView.printLottos(lottos);

        List<Integer> winningNumbers = inputWinnerNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        PrizeResult prizeResult = new PrizeResult();
        prizeResult.calcPrizeResult(winningLotto, lottos);
        outputView.printStatistics(prizeResult, service.getYield(prizeResult, lottoAmount.getAmount()));
    }

    private int inputLottoAmount() {
        while (true) {
            try {
                lottoAmount = new LottoAmount(inputView.inputAmount());
                return lottoAmount.getlottoTicketCount();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private Lottos createLottos(int lottoTicketCount) {
        while (true) {
            try {
                return new Lottos(service.createLottos(lottoTicketCount));
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private List<Integer> inputWinnerNumbers() {
        Lotto winnerLotto = null;
        while (true) {
            try {
                winnerLotto = new Lotto(service.splitStringToIntegerList(inputView.inputWinningNumbers()));
                return winnerLotto.getNumbers();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return validateBonusNumber(winningNumbers, inputView.inputBonusNumber());
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }


}
