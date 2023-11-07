package lotto;

import lotto.dao.LottoRepository;
import lotto.dto.LottoDto;
import lotto.dto.LottoProfitResult;
import lotto.exception.LottoErrorCode;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

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
        outputView.showMessage(lottoDtos.size() + "개를 구매했습니다.");
        lottoDtos.forEach(outputView::showLotto);
        return key;
    }

    private Lottery inputLotteryNumber() {

        outputView.showMessage("당첨 번호를 입력해 주세요.");

        List<Integer> numbers = inputView.inputNumbersSplitByComma();

        Lotto goal = new Lotto(numbers);
        outputView.showMessage("보너스 번호를 입력해 주세요.");

        Integer bonusNumber = inputView.inputNumber();
        return new Lottery(goal, bonusNumber);
    }


    private int askMoneyUntilValid() {
        outputView.showMessage("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return askMoney();
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.showErrorMessage(illegalArgumentException.getMessage());
            }
        }
    }

    private int askMoney() throws IllegalArgumentException {
        Integer money = inputView.inputNumber();
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(LottoErrorCode.WRONG_PRICE.getMessage());
        }
        return money;
    }


}
