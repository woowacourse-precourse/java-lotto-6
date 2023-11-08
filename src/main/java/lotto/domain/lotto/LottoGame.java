package lotto.domain.lotto;

import java.util.List;
import java.util.Optional;
import lotto.domain.GameResult;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.lotto.converter.LottoMessageConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoGame(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }


    public void run() {
        Money money = inputMoneyAmount();
        List<Lotto> lottos = purchaseLottos(money);

        WinningLotto winningLotto = createWinningLotto();
        BonusNumber bonusNumber = createBonusNumber(winningLotto);

        GameResult result = calculateGameResult(winningLotto, bonusNumber, lottos);

        double profitPercentage = result.calculateProfitPercentage(money);
        printResult(result, profitPercentage);
    }

    private Money inputMoneyAmount() {
        try {
            int amount = inputView.readLottoPurchaseMoney();
            return new Money(amount);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
            return inputMoneyAmount();
        }
    }

    private List<Lotto> purchaseLottos(Money money) {
        List<Lotto> lottos = lottoMachine.purchaseLottos(money);
        outputView.println(LottoMessageConverter.convertLottoNumberMessage(lottos));

        return lottos;
    }

    private WinningLotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = inputView.readWinningNumbers();
            return new WinningLotto(winningNumbers);
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
            return createWinningLotto();
        }
    }

    private BonusNumber createBonusNumber(WinningLotto winningLotto) {
        try {
            int number = inputView.readBonusNumber();
            BonusNumber bonusNumber = new BonusNumber(number);
            winningLotto.checkDuplicationWithBonusNumber(bonusNumber);

            return bonusNumber;
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
            return createBonusNumber(winningLotto);
        }
    }

    private GameResult calculateGameResult(WinningLotto winningLotto, BonusNumber bonusNumber, List<Lotto> lottos) {
        GameResult result = GameResult.create();
        for (Lotto lotto : lottos) {
            Optional<Rank> rank = winningLotto.compareNumbers(lotto, bonusNumber);
            rank.ifPresent(result::add);
        }

        return result;
    }

    private void printResult(GameResult result, double profitPercentage) {
        String lottoResultMessage = LottoMessageConverter.convertLottoResultMessage(result, profitPercentage);
        outputView.println(lottoResultMessage);
    }
}
