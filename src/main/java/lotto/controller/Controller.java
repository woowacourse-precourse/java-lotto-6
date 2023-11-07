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
        outputView.printEnterAmountMessage();
        int amount = inputView.readAmount();
        Money money = new Money(amount);
        List<List<Integer>> lottoNumbers = lottoMachineService.generateLotto(money);
        outputView.printLottoPurchases(lottoNumbers);
        List<Lotto> lottos = lottoMachineService.getLottos();

        outputView.printEnterWinningNumbersMessage();
        List<Integer> winningLottoNumbers = inputView.readWinningLottoNumbers();
        Lotto winningLotto = new Lotto(winningLottoNumbers);

        outputView.printEnterBonusMessage();
        int bonus = inputView.readBonus();

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);
        lottoResultService = new LottoResultService(winningNumbers, new RankCounter());

        EnumMap<Rank, Integer> result = lottoResultService.rank(lottos);

        outputView.printStatsTitle();
        result.keySet()
                .stream()
                .filter(rank -> rank != Rank.BLANK)
                .forEach(rank -> outputView.printStats(rank.getDescription(),
                        rank.getAmount(),
                        result.get(rank)
                )
                );

        double rateOfReturn = lottoResultService.getRateOfReturn(amount, result);
        outputView.printRateOfReturn(rateOfReturn);
    }
}
