package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.generator.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final String DELIMITER = ",";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        PurchasedLottos purchasedLottos = tryPurchaseLotto();
        Lotto lotto = tryWinnerLotto();
        LottoNumber lottoNumber = tryBonusBall(lotto);

        WinningLotto winningLotto = new WinningLotto(lotto, lottoNumber);
        tryPrintLottoStatistic(purchasedLottos, winningLotto);
    }

    private void tryPrintLottoStatistic(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {
        List<LottoRank> lottoRanks = purchasedLottos.matchLottos(winningLotto);
        LottoMatchResult lottoMatchResult = LottoMatchResult.createLottoMatchResult(lottoRanks,
                purchasedLottos.spendMoney());
        outputView.outputLottoMatchResult(lottoMatchResult);
    }

    public PurchasedLottos tryPurchaseLotto() {
        try {
            Money money = new Money(inputView.inputMoney());
            RandomNumberGenerator generator = new RandomNumberGenerator();
            PurchasedLottos purchasedLottos = PurchasedLottos.createPurchasedLottos(generator, money);
            outputView.outputPurchasedLottos(purchasedLottos);
            return purchasedLottos;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return tryPurchaseLotto();
        }
    }

    public Lotto tryWinnerLotto() {
        try {
            String inputWinningNumber = inputView.inputWinningNumber();
            List<LottoNumber> winningNumbers = Arrays.stream(inputWinningNumber.split(DELIMITER))
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
            List<Integer> winningLotto = winningNumbers.stream().map(value -> value.toString()).map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new Lotto(winningLotto);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return tryWinnerLotto();
        }
    }

    public LottoNumber tryBonusBall(Lotto lotto) {
        try {
            String inputBonusBall = inputView.inputBonusBall();
            LottoNumber lottoNumber = new LottoNumber(inputBonusBall);
            new WinningLotto(lotto, lottoNumber);
            return lottoNumber;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return tryBonusBall(lotto);
        }
    }
}
