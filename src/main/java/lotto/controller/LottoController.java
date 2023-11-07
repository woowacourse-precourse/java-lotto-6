package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Objects;

public class LottoController {

    private final InputView inputView;
    private final LottoGenerator lottoGenerator;

    public LottoController(InputView inputView,
                           LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.lottoGenerator = lottoGenerator;
    }

    public void draw() {

        int purchaseAmount = inputView.inputPurchaseAmount();
        int numberOfLottos = lottoGenerator.calculateNumberOfLottos(purchaseAmount);

        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.generateLottosByPurchaseAmount(purchaseAmount);

        OutputView.outputLottoTickets(numberOfLottos, lottos);

        String lottoNumber = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        List<Integer> lottoNumbers = Lottos.parseLottoNumber(lottoNumber);
        Lotto winningNumbers = new Lotto(lottoNumbers);

        List<LottoResult> results = lottos.match(winningNumbers, bonusNumber);
        double profitRate = calculateProfitRate(results, purchaseAmount);

        OutputView.outputResult(results, profitRate);
    }

    private double calculateProfitRate(List<LottoResult> results, int purchaseAmount) {
        long totalPrize = results.stream()
                .filter(Objects::nonNull)
                .mapToLong(LottoResult::getPrizeMoney)
                .sum();
        return (double) totalPrize / purchaseAmount * 100;
    }
}
