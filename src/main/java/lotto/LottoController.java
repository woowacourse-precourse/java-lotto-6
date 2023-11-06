package lotto;

import java.util.List;

public class LottoController {

    private static final String INPUT_BUY_AMOUNT = Message.INPUT_BUY_AMOUNT.getValue();
    private static final String LOTTO_BUY_COUNT = Message.LOTTO_BUY_COUNT.getValue();
    private static final String CRLF = Message.CRLF.getValue();
    private static final String INPUT_WINNER_NUMBERS = Message.INPUT_WINNER_NUMBERS.getValue();

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
            winnerNumbers = new WinnerNumbers(numbers);

        } catch (Exception e) {
            view.printMessage(e.getMessage());
            inputWinnerNumber();
            return;
        }

        view.printMessage(CRLF);
    }
}
