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

        try {
            int amount = view.inputNumber(INPUT_BUY_AMOUNT);
            wallet.addBalance(amount);

        } catch (Exception e) {
            view.printMessage(e.getMessage());
            inputAmountOfLotto();

            return;
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

        try {
            List<Integer> numbers = view.inputNumbers(INPUT_WINNER_NUMBERS);
            view.printMessage(CRLF);
            WinnerNumbers.validateNumbers(numbers);

            int bonusNumber = view.inputNumber(INPUT_BONUS_NUMBER);
            winnerNumbers = new WinnerNumbers(numbers, bonusNumber);

        } catch (Exception e) {
            view.printMessage(e.getMessage());
            inputWinnerNumber();
            return;
        }

        view.printMessage(CRLF);
    }
}
