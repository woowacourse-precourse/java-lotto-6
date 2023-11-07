package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchasedLottos;
import lotto.domain.WinningLotto;
import lotto.utils.RandomLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import net.bytebuddy.pool.TypePool.Resolution.Illegal;


public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        PurchasedLottos purchasedlottos = tryPurchaseLotto();
        Lotto lotto = tryWinnerLotto();
        LottoNumber lottoNumber = tryBonusBall(lotto);

        WinningLotto winningLotto = new WinningLotto(lotto, lottoNumber);
        tryPrintLottoStatistics()
    }

    private void tryPrintLottoStatistics(PurchasedLottos purchasedLottos, WinningLotto winningLotto) {

    }

    private LottoNumber tryBonusBall(Lotto lotto) {
        try {
            String inputBonusBall = inputView.requestBonusNumber();
            LottoNumber lottoNumber = new LottoNumber(inputBonusBall);
            new WinningLotto(lotto, lottoNumber);
            return lottoNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return tryBonusBall(lotto);
        }
    }

    private Lotto tryWinnerLotto() {
        try {
            String inputWinningNumber = inputView.requestWinNumbers();
            List<LottoNumber> winningNumbers = Arrays.stream(inputWinningNumber.split(","))
                    .map(LottoNumber::new)
                    .collect(Collectors.toList());
            List<Integer> winningLotto = winningNumbers.stream()
                    .map(value -> value.toString())
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new Lotto(winningLotto);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return tryWinnerLotto();
        }

    }

    private PurchasedLottos tryPurchaseLotto() {
        try {
            Amount amount = new Amount(inputView.requestAmount());
            RandomLottoNumbersGenerator generator = new RandomLottoNumbersGenerator();
            PurchasedLottos purchasedLottos = PurchasedLottos.createPurchasedLottos(generator, amount);
            outputView.outputPurchasedLottos(purchasedLottos);
            return purchasedLottos;
        } catch (IllegalArgumentException e) {
            System.out.println("");
            return tryPurchaseLotto();
        }
    }


}
