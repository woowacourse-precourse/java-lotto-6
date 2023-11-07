package lotto.controller;

import lotto.convertor.Convertor;
import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ticket;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.Result;
import lotto.dto.ResultsDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Ticket ticket = createTicket();
        final Lottos lottos = ticket.buyLottos(new RandomNumberGenerator());

        outputView.printLottoNumbers(lottos.getLottoNumbers());

        final AnswerLotto answerLotto = createAnswerLotto(createMainLotto());
        final Result result = lottos.calculateResult(answerLotto);

        outputView.printResults(ResultsDto.from(result));
        outputView.printRateOfReturn(result.calculateRateToReturn());

        inputView.close();
    }

    private Ticket createTicket() {
        while (true) {
            try {
                return Ticket.from(Convertor.toInt(inputView.enterMoney()));
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException.getMessage());
            }
        }
    }

    private Lotto createMainLotto() {
        while (true) {
            try {
                return new Lotto(Convertor.toIntegerList(inputView.enterLotto()));
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException.getMessage());
            }
        }
    }

    private AnswerLotto createAnswerLotto(final Lotto mainLotto) {
        while (true) {
            try {
                return AnswerLotto.of(mainLotto, Convertor.toInt(inputView.enterBonusNumber()));
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException.getMessage());
            }
        }
    }

}
