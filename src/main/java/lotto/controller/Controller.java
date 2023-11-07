package lotto.controller;

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

    public Controller(InputView inputView, OutputView outputView, LottoMachineService lottoMachineService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachineService = lottoMachineService;
    }

    public void execute() {
        int input = readInputMoney();
        List<Lotto> lottos = generateLotto(input);

        Lotto winningLotto = readWinningLotto();
        int bonus = readBonus();
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);

        lottoResultService = new LottoResultService(winningNumbers, new RankCounter());
        EnumMap<Rank, Integer> result = lottoResultService.rank(lottos);

        printStats(result);
        printRateOfReturn(input, result);
    }

    private int readInputMoney() {
        outputView.printEnterAmountMessage();
        return inputView.readAmount();
    }

    private List<Lotto> generateLotto(int amount) {
        Money money = new Money(amount);
        List<List<Integer>> lottoNumbers = lottoMachineService.generateLotto(money);
        outputView.printLottoPurchases(lottoNumbers);
        return lottoMachineService.getLottos();
    }

    private Lotto readWinningLotto() {
        outputView.printEnterWinningNumbersMessage();
        List<Integer> winningLottoNumbers = inputView.readWinningLottoNumbers();
        return new Lotto(winningLottoNumbers);
    }

    private int readBonus() {
        outputView.printEnterBonusMessage();
        return inputView.readBonus();
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
