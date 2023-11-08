package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Balance;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoDraw;
import lotto.dto.LottoResults;
import lotto.strategy.IssuanceStrategy;
import lotto.strategy.QuickpickIssuanceStrategy;
import lotto.utils.Parser;
import lotto.utils.RetryExecutor;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGame {
    public void play() {
        Balance balance = withRetry(this::createBalance);
        List<Lotto> lottos = purchaseLottosWithQuckpick(balance);

        Lotto winningLotto = withRetry(this::generateWinningLotto);
        Bonus winningBonus = withRetry(() -> generateWinningBonus(winningLotto));
        Console.close();
        LottoDraw lottoDraw = LottoDraw.of(winningLotto, winningBonus);

        processLottoResults(lottoDraw, lottos, balance);
    }

    private Balance createBalance() {
        String userInput = Input.getPurchaseAmount();
        int purchaseAmount = Parser.parsePurchaseAmount(userInput);
        return Balance.create(purchaseAmount);
    }

    private List<Lotto> purchaseLottosWithQuckpick(Balance balance) {
        IssuanceStrategy issuanceStrategy = new QuickpickIssuanceStrategy();
        LottoMachine lottoMachine = LottoMachine.create(issuanceStrategy);

        List<Lotto> lottos = lottoMachine.purchaseAll(balance);
        Output.printPurchasedLottoNumbers(lottos);

        return lottos;
    }

    private Lotto generateWinningLotto() {
        String userInput = Input.getWinningNumbers();
        List<Integer> winningNumbers = Parser.parseWinningNumbers(userInput);

        return Lotto.from(winningNumbers);
    }

    private Bonus generateWinningBonus(Lotto winningLotto) {
        String userInput = Input.getBonusNumber();
        int bonusNumber = Parser.parseBonusNumber(userInput);

        return Bonus.createWithValidate(bonusNumber, winningLotto);
    }

    private void processLottoResults(LottoDraw lottoDraw, List<Lotto> lottos, Balance balance) {
        LottoChecker lottoChecker = new LottoChecker(lottoDraw, lottos);

        int purchaseAmount = balance.getPurchaseAmount();
        LottoResults lottoResults = lottoChecker.createLottoResults(purchaseAmount);
        Output.printResults(lottoResults);
    }

    private <T> T withRetry(Supplier<T> function) {
        return RetryExecutor.execute(function, IllegalArgumentException.class);
    }
}

