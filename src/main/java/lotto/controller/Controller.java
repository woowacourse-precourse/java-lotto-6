package lotto.controller;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.Money;
import lotto.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.service.LottoMachineService;
import lotto.service.LottoResultService;
import lotto.service.RankCounter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachineService lottoMachineService;
    private LottoResultService lottoResultService;

    public Controller(
            final InputView inputView,
            final OutputView outputView,
            final LottoMachineService lottoMachineService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachineService = lottoMachineService;
    }

    public void execute() {
        Money money = readAmount();
        List<Lotto> lottos = generateLotto(money);

        Lotto winningLotto = readWinningLotto();
        int bonus = readBonus();
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);

        lottoResultService = new LottoResultService(winningNumbers, new RankCounter());
        EnumMap<Rank, Integer> result = lottoResultService.rank(lottos);

        printStats(result);
        printRateOfReturn(money.amount(), result);
    }

    private Money readAmount() {
        outputView.printEnterAmountMessage();
        Money money = null;
        while (money == null) {
            money = readAmountInput();
        }
        return money;
    }

    private Money readAmountInput() {
        try {
            int amount = inputView.readAmount();
            return new Money(amount);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return null;
    }

    private List<Lotto> generateLotto(Money money) {
        List<List<Integer>> lottoNumbers = lottoMachineService.generateLotto(money);
        outputView.printLottoPurchases(lottoNumbers);
        return lottoMachineService.getLottos();
    }

    private Lotto readWinningLotto() {
        outputView.printEnterWinningNumbersMessage();
        List<Integer> winningLottoNumbers = Collections.emptyList();
        while (winningLottoNumbers.isEmpty()) {
            winningLottoNumbers = readWinningLottoInput();
        }
        return new Lotto(winningLottoNumbers);
    }

    private List<Integer> readWinningLottoInput() {
        try {
            return inputView.readWinningLottoNumbers();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return Collections.emptyList();
    }

    private int readBonus() {
        outputView.printEnterBonusMessage();
        int bonus = 0;
        while (bonus == 0) {
            bonus = readBonusInput();
        }
        return bonus;
    }

    private int readBonusInput() {
        try {
            return inputView.readBonus();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
        return 0;
    }

    private void printStats(EnumMap<Rank, Integer> result) {
        outputView.printStatsTitle();
        result.keySet()
                .stream()
                .filter(rank -> rank != Rank.BLANK)
                .forEach(rank -> outputView.printStats(rank.getDescription(),
                                rank.getAmount(),
                                result.get(rank)
                        )
                );
    }

    private void printRateOfReturn(int amount, EnumMap<Rank, Integer> result) {
        double rateOfReturn = lottoResultService.getRateOfReturn(amount, result);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
