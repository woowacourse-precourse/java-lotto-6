package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.RandomLottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            outputView.writeLottoPurchaseMoney();
            Money purchaseMoney = inputView.readUserPurchaseMoney();
            int quantity = purchaseMoney.quantityAvailableForPurchase(1000);
            outputView.writeBlank();

            List<Lotto> lottos = RandomLottoFactory.generateLottos(quantity);
            outputView.writeGeneratedLotto(lottos);
            outputView.writeBlank();

            outputView.writeLottoWinningNumbers();
            List<LottoNumber> lottoNumbers = inputView.readWinnerLottoNumbers();
            outputView.writeBlank();

            outputView.writeLottoBonusNumber();
            LottoNumber bonusNumber = inputView.readBonusNumber();
            outputView.writeBlank();

            // TODO : 로또 결과 계산

            outputView.writeResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
