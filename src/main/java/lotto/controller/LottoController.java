package lotto.controller;

import static lotto.view.InputView.readLine;
import static lotto.view.constants.ViewMessage.GET_BONUS_NUMBER;
import static lotto.view.constants.ViewMessage.GET_WINNING_NUMBER;

import lotto.domain.Bonus;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.NumberChecker;
import lotto.exception.LottoException;
import lotto.service.LottoService;
import lotto.service.NumberCheckerService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    private final NumberCheckerService numberCheckerService = new NumberCheckerService();

    public Lottos createLottoTicket(Buyer buyer) {
        return lottoService.generateLottoTicket(buyer);
    }

    public NumberChecker createNumberChecker() {
        Lotto winningLotto = createWinningLotto();

        Bonus bonus = createBonus(winningLotto);

        return numberCheckerService.generateNumberChecker(winningLotto, bonus);
    }

    private Bonus createBonus(final Lotto winningLotto) {
        while (true) {
            try {
                OutputView.printMessage(GET_BONUS_NUMBER);
                return numberCheckerService.generateBonus(readLine(), winningLotto);
            } catch (LottoException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }

    private Lotto createWinningLotto() {
        while (true) {
            try {
                OutputView.printMessage(GET_WINNING_NUMBER);
                return numberCheckerService.generateWinningLotto(readLine());
            } catch (LottoException e) {
                OutputView.printMessage(e.getMessage());
            }
        }
    }
}
