package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.service.LottoPaymentService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoPaymentService lottoPaymentService;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(final InputView inputView, final ResultView resultView,
                           final LottoPaymentService lottoPaymentService,
                           final LottoNumberGenerator lottoNumberGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoPaymentService = lottoPaymentService;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        int numberOfLottos = findValidNumberOfLottos();
        List<Lotto> purchasedLottos = generateLottos(numberOfLottos);
        resultView.displayPurchasedLottos(purchasedLottos);

        Lotto winningLotto = askValidWinningLotto();
    }

    private int findValidNumberOfLottos() {
        int numberOfLottos;
        do {
            numberOfLottos = findNumberOfLottos();
        } while (numberOfLottos == -1);
        return numberOfLottos;
    }

    private int findNumberOfLottos() {
        try {
            final int inputMoney = inputView.getInputMoney();
            return lottoPaymentService.calculateNumberOfLottos(inputMoney);
        } catch (IllegalArgumentException e) {
            resultView.printException(e);
            return -1;
        }
    }

    private List<Lotto> generateLottos(final int numberOfLottos) {
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
    }

    private Lotto askValidWinningLotto() {
        Lotto winningLotto;
        do {
            winningLotto = askWinningLotto();
        } while (winningLotto == null);
        return winningLotto;
    }

    private Lotto askWinningLotto() {
        try {
            final List<Integer> winningNumbers = inputView.getWinningNumbers();
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException e) {
            resultView.printException(e);
            return null;
        }
    }
}
