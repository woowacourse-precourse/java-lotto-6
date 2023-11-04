package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoResult;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
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
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Lottos lottos = generateLottos(money, numberGenerator);
        WinningLotto winningLotto = makeWinningLotto();
        Map<Rank, Integer> winningStatus = getWinningStatus(winningLotto, lottos);
        double revenue = getRevenue(winningStatus, money);
        printResult(winningStatus, revenue);
    }

    private Money getMoney() {
        outputView.printPurchaseMessage();
        String input = inputView.readInput();
        return Money.from(input);
    }

    private Lottos generateLottos(final Money money, final NumberGenerator numberGenerator) {
        int buyCount = money.buyLotto();
        outputView.printBuyLotto(buyCount);
        List<Lotto> generatedLottos = createLottos(buyCount, numberGenerator);
        return new Lottos(generatedLottos);
    }

    private List<Lotto> createLottos(final int buyCount, final NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < buyCount; count++) {
            List<Integer> randomNumbers = numberGenerator.generateSortedList();
            outputView.printLotto(randomNumbers);
            Lotto lotto = Lotto.fromIntegerList(randomNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        String lottoNumbers = inputView.readInput();
        String bonusNumber = inputView.readInput();
        List<String> lotto = Converter.convertCommaSeparatedStringToList(lottoNumbers);
        return WinningLotto.of(lotto, bonusNumber);
    }

    private Map<Rank, Integer> getWinningStatus(final WinningLotto winningLotto, final Lottos lottos) {
        Map<Rank, Integer> ranks = new HashMap<>();
        List<Lotto> lottoss = lottos.getLottos();
        lottoss.forEach(lotto -> {
            int sameCount = winningLotto.getSameCount(lotto.getNumbers());
            boolean matchBonus = winningLotto.isMatchBonus(lotto.getNumbers());
            Rank rank = Rank.getRank(sameCount, matchBonus);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        });
        return ranks;
    }

    public double getRevenue(final Map<Rank, Integer> status, final Money money) {
        long sumOfPrice = sumOfPrice(status);
        return money.calculateRevenue(sumOfPrice);
    }

    private long sumOfPrice(final Map<Rank, Integer> status) {
        return status.entrySet().stream()
                .map(entry -> {
                    Rank rank = entry.getKey();
                    return rank.getPrice() * entry.getValue();
                })
                .reduce(0L, Long::sum);
    }

    private void printResult(final Map<Rank, Integer> status, final double revenue) {
        outputView.printResult(LottoResult.from(status), revenue);
    }
}
