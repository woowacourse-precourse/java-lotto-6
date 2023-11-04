package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoResult;
import lotto.controller.dto.WinningResult;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.Converter;
import lotto.util.NumberGenerator;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Money money = getMoney();
        Lottos lottos = generateLottos(money, new RandomNumberGenerator());
        printLottos(lottos);
        WinningLotto winningLotto = generateWinningLotto();
        Map<Rank, Integer> winningStatus = calculateWinningStatus(winningLotto, lottos);
        double revenue = getReturnRate(winningStatus, money);
        printResult(winningStatus, revenue);
    }

    private Money getMoney() {
        try {
            outputView.printPurchaseMessage();
            String input = inputView.readInput();
            return Money.from(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return getMoney();
        }
    }

    private Lottos generateLottos(final Money money, final NumberGenerator numberGenerator) {
        int buyCount = money.buyLotto();
        outputView.printBuyLotto(buyCount);
        return Lottos.of(buyCount, numberGenerator);
    }

    private void printLottos(final Lottos lottos) {
        for (final Lotto lotto : lottos.getLottos()) {
            outputView.printLotto(LottoResult.from(lotto.getNumbers()));
        }
    }

    private WinningLotto generateWinningLotto() {
        Lotto lotto = generateWinningLottoNumbers();
        Number bonusNumber = generateBonusNumber();
        return new WinningLotto(lotto, bonusNumber);
    }

    private Lotto generateWinningLottoNumbers() {
        try {
            String input = inputView.readInput();
            List<String> lotto = Converter.convertCommaSeparatedStringToList(input);
            return Lotto.fromStringList(lotto);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return generateWinningLottoNumbers();
        }
    }

    private Number generateBonusNumber() {
        try {
            String input = inputView.readInput();
            return Number.from(input);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return generateBonusNumber();
        }
    }

    private Map<Rank, Integer> calculateWinningStatus(final WinningLotto winningLotto, final Lottos lottos) {
        Map<Rank, Integer> winningStatus = new EnumMap<>(Rank.class);
        List<Lotto> lottoList = lottos.getLottos();

        for (Lotto lotto : lottoList) {
            Rank rank = calculateRank(winningLotto, lotto);
            winningStatus.put(rank, winningStatus.getOrDefault(rank, 0) + 1);
        }

        return winningStatus;
    }

    private Rank calculateRank(final WinningLotto winningLotto, final Lotto lotto) {
        int sameCount = winningLotto.countMatchingNumbers(lotto.getNumbers());
        boolean matchBonus = winningLotto.hasMatchingBonus(lotto.getNumbers());
        return Rank.of(sameCount, matchBonus);
    }

    public double getReturnRate(final Map<Rank, Integer> status, final Money money) {
        long sumOfPrice = calculateSumOfPrice(status);
        return money.calculateReturnRate(sumOfPrice);
    }

    private long calculateSumOfPrice(final Map<Rank, Integer> status) {
        return status.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    private void printResult(final Map<Rank, Integer> status, final double revenue) {
        outputView.printResult(WinningResult.from(status), revenue);
    }
}
