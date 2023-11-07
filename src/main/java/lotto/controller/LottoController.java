package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberGenerator numberGenerator;
    private final Calculator calculator;

    public LottoController(final NumberGenerator numberGenerator, final Calculator calculator) {
        this.numberGenerator = numberGenerator;
        this.calculator = calculator;
    }

    public void start() {
        Money money = getValidMoneyInput();
        int ticketCount = money.calculateTicketCount();
        OutputView.printTicketCount(ticketCount);
        Lottos userLottos = generateUserLottos(ticketCount);
        OutputView.printUserLottos(userLottos.getLottos());
        WinningNumbers winningNumbers = getValidWinningNumbersInput();
        BonusNumber bonusNumber = getValidBonusNumberInput(winningNumbers);
        Map<Rank, Integer> rankCount = calculator.calculateRankCount(userLottos.getLottos(), winningNumbers,
                bonusNumber);
        OutputView.printWinningStatistics();
        OutputView.printRankCount(rankCount);
        printRateOfReturn(rankCount, money);
    }

    private <T> T getValidInput(Supplier<T> inputSupplier) {
        return Stream.generate(() -> tryGet(inputSupplier))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow();
    }

    private <T> Optional<T> tryGet(Supplier<T> inputSupplier) {
        try {
            return Optional.of(inputSupplier.get());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return Optional.empty();
        }
    }

    private Money getValidMoneyInput() {
        return getValidInput(() -> new Money(InputView.getMoneyInput()));
    }

    private Lottos generateUserLottos(int ticketCount) {
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(i -> generateValidLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private Lotto generateValidLotto() {
        return getValidInput(() -> new Lotto(numberGenerator.createRandomLottoNumbers()));
    }

    private WinningNumbers getValidWinningNumbersInput() {
        return getValidInput(() -> new WinningNumbers(InputView.getWinningNumbersInput()));
    }

    private BonusNumber getValidBonusNumberInput(WinningNumbers winningNumbers) {
        return getValidInput(() -> new BonusNumber(InputView.getBonusNumberInput(), winningNumbers));
    }

    private void printRateOfReturn(Map<Rank, Integer> rankCount, Money money) {
        int totalPrize = calculator.calculateTotalPrize(rankCount);
        double rateOfReturn = calculator.calculateRateOfReturn(totalPrize, money);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}