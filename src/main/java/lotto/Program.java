package lotto;

import lotto.constants.LottoConstants;
import lotto.dao.LottoRepository;
import lotto.dto.LottoDto;
import lotto.dto.LottoProfitResult;
import lotto.exception.LottoErrorCode;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

import static lotto.constants.Message.*;

public class Program {

    private final InputView inputView;
    private final OutputView outputView;

    private final LottoService lottoService;

    public Program() {
        inputView = new ConsoleInputView();
        outputView = new ConsoleOutputView();

        LottoRepository lottoRepository = new LottoRepository();
        lottoService = new LottoService(lottoRepository);
    }

    public void run() {
        String key = buyLotto();

        Lottery lottery = inputLotteryNumber();

        LottoProfitResult lottoProfitResult = lottoService.checkProfit(key, lottery.lotto(), lottery.bonusNumber());
        outputView.showResult(lottoProfitResult);
    }


    private String buyLotto() {
        int money = askMoneyUntilValid();

        String key = lottoService.buyLotto(money);
        List<LottoDto> lottoDtos = lottoService.getLottos(key);

        outputView.showMessage();
        outputView.showMessage(lottoDtos.size() + BOUGHT_N_AMOUNT);
        lottoDtos.forEach(outputView::showLotto);
        return key;
    }


    private int askMoneyUntilValid() {
        outputView.showMessage(INPUT_LOTTO_BUYING_MONEY);
        return executeWithRetry(this::askMoney);
    }

    private int askMoney() throws IllegalArgumentException {
        int money = inputView.inputNumber();
        if (money < LottoConstants.LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoErrorCode.NOT_ENOUGH_MONEY.getMessage());
        }
        if (money % LottoConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LottoErrorCode.WRONG_PRICE.getMessage());
        }
        return money;
    }

    private Lottery inputLotteryNumber() {
        Lotto goal = inputNumbersUntilValid();
        return inputBonusNumber(goal);
    }

    private Lotto inputNumbersUntilValid() {
        outputView.showMessage(INPUT_LOTTO_GOAL);
        return executeWithRetry(() -> {
            List<Integer> numbers = inputView.inputNumbersSplitByComma();
            return new Lotto(numbers);
        });
    }

    private Lottery inputBonusNumber(Lotto goal) {
        outputView.showMessage(INPUT_LOTTO_BONUS);
        return executeWithRetry(() -> {
            Integer bonusNumber = inputView.inputNumber();
            return new Lottery(goal, bonusNumber);
        });
    }


    private <T> T executeWithRetry(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (IllegalArgumentException exception) {
                outputView.showErrorMessage(exception.getMessage());
            }
        }
    }

}
