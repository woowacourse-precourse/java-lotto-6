package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.NumberGenerator;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    public static final int lottoPrice = 1000;

    private NumberGenerator lottoGenerator;

    public LottoController(NumberGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public void start() {
        int purchaseAmount = InputView.inputPurchaseAmount();

        Lottos userLottos = purchaseLottos(purchaseAmount);
        OutputView.printPurchaseLottos(userLottos.toDtos());

        Lotto winningNumbers = inputWinningNumber();

        BonusNumber bonusNumber = inputBonusNumber();

        List<LottoResult> results = userLottos.getLottoWinningResult(winningNumbers, bonusNumber);
        OutputView.printLottoResult(results);

        double totalEarningsRate = calculateTotalEarningsRate(results, purchaseAmount);
        OutputView.printTotalEarningsRate(totalEarningsRate);
    }

    private Lotto inputWinningNumber() {
        return new Lotto(InputView.inputWinningNumber());
    }

    private BonusNumber inputBonusNumber() {
        return new BonusNumber(InputView.inputBonusNumber());
    }

    private Lottos purchaseLottos(int purchaseAmount) {
        int purchasableLottoCount = purchaseAmount / lottoPrice;

        List<Lotto> lottos = IntStream.range(0, purchasableLottoCount)
                .mapToObj(i -> purchaseLotto())
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    private Lotto purchaseLotto() {
        return new Lotto(lottoGenerator.generateNumbers());
    }

    private double calculateTotalEarningsRate(List<LottoResult> results, int purchaseAmount) {
        Long totalPrize = results.stream()
                .map(LottoResult::parsePrizeAmount)
                .reduce((a, b) -> a + b)
                .orElse(0L);
        return ((double) totalPrize * 100) / (double) purchaseAmount;
    }

}
