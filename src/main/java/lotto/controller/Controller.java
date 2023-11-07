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

    public Controller(InputView inputView, OutputView outputView, LottoMachineService lottoMachineService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachineService = lottoMachineService;
    }

    public void execute() {
        int input = readAmount();
        List<Lotto> lottos = generateLotto(input);

        Lotto winningLotto = readWinningLotto();
        int bonus = readBonus();
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);

        lottoResultService = new LottoResultService(winningNumbers, new RankCounter());
        EnumMap<Rank, Integer> result = lottoResultService.rank(lottos);

        printStats(result);
        printRateOfReturn(input, result);
    }

    private int readAmount() {
        outputView.printEnterAmountMessage();
        int amount = 0;
        while (amount == 0) {
            amount = readAmountInput();
        }
        return amount;
    }

    private int readAmountInput() {
        try {
            return inputView.readAmount();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage("구입 금액을 1000원 단위의 숫자여야 합니다.");
        }
        return 0;
    }

    private List<Lotto> generateLotto(int amount) {
        Money money = new Money(amount);
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
            outputView.printErrorMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
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
            outputView.printErrorMessage("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
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
