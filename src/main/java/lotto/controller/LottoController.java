package lotto.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import lotto.constant.Rank;
import lotto.domain.Lotto;
import lotto.dto.LottoPlayInfo;
import lotto.dto.LottoResult;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoController {
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoResultService lottoResultService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoPurchaseService lottoPurchaseService, LottoResultService lottoResultService,
        InputView inputView, OutputView outputView) {
        this.lottoPurchaseService = lottoPurchaseService;
        this.lottoResultService = lottoResultService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = getInputSafely(this::tryInputPurchaseAmount);
        List<Lotto> lottos = purchaseLotto(purchaseAmount);
        LottoResult lottoResult = getInputSafely(() -> tryInputLottoResult(lottos, purchaseAmount));

        List<Rank> ranks = lottoResult.matchedCounts();
        double roi = lottoResult.roi();
        outputView.displayResults(ranks, roi);
    }

    private List<Lotto> purchaseLotto(int purchaseAmount) {
        List<Lotto> lottos = lottoPurchaseService.buyLottos(purchaseAmount);
        List<String> purchasedLotto = lottos.stream()
            .map(Lotto::toString)
            .toList();
        outputView.displayLottos(purchasedLotto);
        return lottos;
    }


    private <T> T getInputSafely(Supplier<Optional<T>> inputSupplier) {
        Optional<T> result;
        do {
            result = inputSupplier.get();
        } while (result.isEmpty());
        return result.get();
    }

    private Optional<Integer> tryInputPurchaseAmount() {
        try {
            return Optional.of(inputView.inputPurchaseAmount());
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }

    private Optional<LottoResult> tryInputLottoResult(List<Lotto> lottos, int purchaseAmount) {
        try {
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();
            return Optional.of(lottoResultService.getLottoResult(lottos,
                new LottoPlayInfo(winningNumbers, bonusNumber, purchaseAmount)));
        } catch (IllegalArgumentException e) {
            outputView.displayErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }



}
