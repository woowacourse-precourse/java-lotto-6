package lotto;

import static lotto.constant.GuideMessage.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.domain.WinnerNumbers;

public class LottoController {

    private static final String CRLF = "";

    private static final Wallet wallet = new Wallet();
    private static final LottoView view = new LottoView();
    private static WinnerNumbers winnerNumbers;


    void inputAmountOfLotto() {

        boolean exceptionOccurrenceStatus = true;

        while (exceptionOccurrenceStatus) {
            try {
                int amount = view.inputNumber(INPUT_BUY_AMOUNT);
                wallet.addBalance(amount);

                exceptionOccurrenceStatus = false;

            } catch (Exception e) {
                view.printMessage(e.getMessage());
                exceptionOccurrenceStatus = true;
            }
        }

        view.printMessage(CRLF);
    }

    void buyLotto() {

        wallet.buyAllLotto();

        List<Lotto> lottos = wallet.getLottos();

        view.printMessage(lottos.size() + LOTTO_BUY_COUNT);

        for (Lotto lotto : lottos) {
            view.printMessage(lotto.getNumbers().toString());
        }

        view.printMessage(CRLF);
    }

    void inputWinnerNumber() {

        boolean exceptionOccurrenceStatus = true;

        while (exceptionOccurrenceStatus) {
            try {
                List<Integer> numbers = view.inputNumbers(INPUT_WINNER_NUMBERS);
                view.printMessage(CRLF);
                WinnerNumbers.validateNumbers(numbers);

                inputBonusNumber(numbers);

                exceptionOccurrenceStatus = false;

            } catch (Exception e) {
                view.printMessage(e.getMessage());
                exceptionOccurrenceStatus = true;
            }
        }

        view.printMessage(CRLF);
    }

    private int inputBonusNumber(List<Integer> numbers) {

        int bonusNumber = 0;

        boolean exceptionOccurrenceStatus = true;

        while (exceptionOccurrenceStatus) {
            try {
                bonusNumber = view.inputNumber(INPUT_BONUS_NUMBER);
                winnerNumbers = new WinnerNumbers(numbers, bonusNumber);
                exceptionOccurrenceStatus = false;

            } catch (Exception e) {
                view.printMessage(e.getMessage());
                exceptionOccurrenceStatus = true;
            }
        }

        return bonusNumber;
    }
}
