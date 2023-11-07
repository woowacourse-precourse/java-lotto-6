package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.view.OutputView;

public class LottoManager {
    private final NumberGenerator numberGenerator;
    private final Calculator calculator;

    public LottoManager(final NumberGenerator numberGenerator, final Calculator calculator) {
        this.numberGenerator = numberGenerator;
        this.calculator = calculator;
    }

    public Lottos generateUserLottos(int ticketCount) {
        List<Lotto> lottos = IntStream.range(0, ticketCount)
                .mapToObj(i -> generateValidLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    private Lotto generateValidLotto() {
        return getValidInput(() -> new Lotto(numberGenerator.createRandomLottoNumbers()));
    }

    public <T> T getValidInput(Supplier<T> inputSupplier) {
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

    public Map<Rank, Integer> calculateRankCount(Lottos userLottos, WinningNumbers winningNumbers,
                                                 BonusNumber bonusNumber) {
        return calculator.calculateRankCount(userLottos.getLottos(), winningNumbers, bonusNumber);
    }

    public void printRateOfReturn(Map<Rank, Integer> rankCount, Money money) {
        int totalPrize = calculator.calculateTotalPrize(rankCount);
        double rateOfReturn = calculator.calculateRateOfReturn(totalPrize, money);
        OutputView.printRateOfReturn(rateOfReturn);
    }
}
