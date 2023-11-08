package lotto;

import static lotto.constant.GuideMessage.*;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lotto.constant.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.LottoStatistics;
import lotto.domain.Wallet;
import lotto.domain.WinnerNumbers;

public class LottoController {

    private static final String CRLF = "";
    private static final Wallet wallet = new Wallet();
    private static final LottoView view = new LottoView();

    private final Supplier<Boolean> inputAmountOfLotto = () -> {

        boolean exceptionOccurrenceStatus;

        try {
            int amount = view.inputNumber(INPUT_BUY_AMOUNT);
            wallet.addBalance(amount);

            exceptionOccurrenceStatus = false;

        } catch (IllegalArgumentException e) {
            view.printMessage(e.getMessage());
            exceptionOccurrenceStatus = true;
        }

        view.printMessage(CRLF);

        return exceptionOccurrenceStatus;
    };

    private final Supplier<Boolean> inputWinnerNumber = () -> {
        boolean exceptionOccurrenceStatus;

        try {
            List<Integer> numbers = view.inputNumbers(INPUT_WINNER_NUMBERS);
            view.printMessage(CRLF);
            Lotto.validate(numbers);

            int bonusNumber = inputBonusNumber(numbers);
            winnerNumbers = new WinnerNumbers(numbers, bonusNumber);

            exceptionOccurrenceStatus = false;

        } catch (IllegalArgumentException e) {
            view.printMessage(e.getMessage());
            exceptionOccurrenceStatus = true;
        }

        view.printMessage(CRLF);

        return exceptionOccurrenceStatus;
    };

    private static WinnerNumbers winnerNumbers;

    void run() {

        loopMethod(inputAmountOfLotto);

        buyLotto();

        loopMethod(inputWinnerNumber);

        showTotalLottoResult();
    }

    void showTotalLottoResult() {

        LottoStatistics lottoStatistics = new LottoStatistics();
        List<Lotto> lottos = wallet.getLottos();
        int balance = wallet.getBalance();

        Map<LottoResult, Integer> lottoResult = lottoStatistics.calculateLottoResults(lottos, winnerNumbers);
        double rateOfReturn = lottoStatistics.calculateLottoRateOfReturn(balance);

        view.printLottoResult(lottoResult, rateOfReturn);

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

    private void loopMethod(Supplier<Boolean> method) {
        while (method.get());
    }

    private int inputBonusNumber(List<Integer> numbers) {

        int bonusNumber = 0;

        boolean exceptionOccurrenceStatus = true;

        while (exceptionOccurrenceStatus) {
            try {
                bonusNumber = view.inputNumber(INPUT_BONUS_NUMBER);
                WinnerNumbers.validateBonusNumber(numbers, bonusNumber);
                exceptionOccurrenceStatus = false;

            } catch (IllegalArgumentException e) {
                view.printMessage(e.getMessage());
                exceptionOccurrenceStatus = true;
            }
        }

        return bonusNumber;
    }
}
