package lotto.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
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
        List<Lotto> purchasedLottos = purchaseLottos();

        Lotto drawNumbers = askValidWinningLotto();
        WinningLotto drawWithBonus = askValidBonusBall(drawNumbers);
        
        LottoResult lottoResult = new LottoResult(purchasedLottos, drawWithBonus);
    }


    private List<Lotto> purchaseLottos() {
        int numberOfLottos = askValidNumberOfLottos();
        List<Lotto> purchasedLottos = generateLottos(numberOfLottos);
        resultView.displayPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private int askValidNumberOfLottos() {
        return askUntilValid(this::askNumberOfLottos, "유효한 로또 수가 필요합니다.");
    }

    private Optional<Integer> askNumberOfLottos() {
        try {
            final int inputMoney = inputView.inputMoney();
            return Optional.of(lottoPaymentService.calculateNumberOfLottos(inputMoney));
        } catch (IllegalArgumentException e) {
            resultView.printException(e);
            return Optional.empty();
        }
    }

    private List<Lotto> generateLottos(final int numberOfLottos) {
        return IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .toList();
    }


    private Lotto askValidWinningLotto() {
        return askUntilValid(this::askWinningLotto, "유효한 당첨 번호가 필요합니다.");
    }

    private Optional<Lotto> askWinningLotto() {
        try {
            final List<Integer> winningNumbers = inputView.inputWinningNumbers();
            return Optional.of(new Lotto(winningNumbers));
        } catch (IllegalArgumentException e) {
            resultView.printException(e);
            return Optional.empty();
        }
    }

    private WinningLotto askValidBonusBall(final Lotto winningLotto) {
        return askUntilValid(() -> askBonusBall(winningLotto), "유효한 보너스 번호가 필요합니다.");
    }

    private Optional<WinningLotto> askBonusBall(final Lotto winningLotto) {
        try {
            final int bonusBall = inputView.inputBonusBall();
            return Optional.of(new WinningLotto(winningLotto, bonusBall));
        } catch (IllegalArgumentException e) {
            resultView.printException(e);
            return Optional.empty();
        }
    }


    private <T> T askUntilValid(Supplier<Optional<T>> asker, String failMessage) {
        return Stream.generate(asker)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(failMessage));
    }
}
