package lotto;

import console.Input;
import console.Output;
import consts.Mark;
import consts.Rank;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final Input input;
    private final Output output;
    private LottoService lottoService;

    private LottoController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public static LottoController create(Input input, Output output) {
        return new LottoController(input, output);
    }

    public void running() {
        this.settingPlay();
        this.settingLottoAnswer();

        Map<Rank, Integer> ranks = this.makeLottoResult();
        double profitRate = lottoService.calculateProfitRate(ranks);
        this.showLottoResult(ranks, profitRate);
        input.close();
    }

    private void settingPlay() {
        int purchaseAmount = this.askPurchaseAmount();
        lottoService = LottoService.create(purchaseAmount);
        lottoService.purchaseLotto();
        showLottoNumbers();
    }

    private void settingLottoAnswer() {
        List<Integer> winningNumbers = this.askWinningNumbers();
        int bonusNumber = this.askBonusNumber();

        lottoService.settingLottoAnswer(winningNumbers, bonusNumber);
    }

    private Map<Rank, Integer> makeLottoResult() {
        return lottoService.makeLottoResult();
    }

    private void showLottoResult(Map<Rank, Integer> ranks, double profitRate) {
        output.showWinningStatistics(ranks, profitRate);
    }

    private int askPurchaseAmount() {
        output.askPurchaseAmount();
        String input = this.input.read();
        try {
            LottoValidator.validatePurchaseAmount(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            output.showErrorMessage(e.getMessage());
            return this.askPurchaseAmount();
        }
    }

    private List<Integer> askWinningNumbers() {
        output.askWinningNumber();
        List<String> input = List.of(this.input.read().split(Mark.COMMA.getMark()));
        try {
            LottoValidator.validateWinningNumbers(input);
            return input.stream().map(Integer::parseInt).toList();
        } catch (IllegalArgumentException e) {
            output.showErrorMessage(e.getMessage());
            return this.askWinningNumbers();
        }
    }

    private int askBonusNumber() {
        output.askBonusNumber();
        String input = this.input.read();
        try {
            LottoValidator.validateBonusNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            output.showErrorMessage(e.getMessage());
            return this.askBonusNumber();
        }
    }

    private void showLottoNumbers() {
        List<Lotto> lottos = lottoService.getLottos();
        output.showPurchasedLotto(lottos.size(), lottos);
    }
}
