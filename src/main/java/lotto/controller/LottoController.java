package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoPayment;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoPayment lottoPayment;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(final InputView inputView, final ResultView resultView, final LottoPayment lottoPayment,
                           final LottoNumberGenerator lottoNumberGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoPayment = lottoPayment;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public void run() {
        int numberOfLottos = findValidNumberOfLottos();
        List<Lotto> purchasedLottos = generateLottos(numberOfLottos);
        resultView.displayPurchasedLottos(purchasedLottos);
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
            return lottoPayment.calculateNumberOfLottos(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return -1;
        }
    }

    private List<Lotto> generateLottos(final int numberOfLottos) {
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
    }
}
