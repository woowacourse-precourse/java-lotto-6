package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoWinningProcess {
    public void run() {
        buyLotto();
        setUpWinningLotto();
    }

    public List<Lotto> buyLotto() {
        PurchaseMoney purchaseMoney = setUpPurchaseMoney();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseMoney.getLottoQuantity(); i++) {
            Lotto lotto = new Lotto(NumberGenerator.generate());
            OutputView.printLottoNumbers(lotto.getNumbers());
            lottos.add(lotto);
        }

        return lottos;
    }

    private PurchaseMoney setUpPurchaseMoney() {
        String purchaseMoney = InputView.inputPurchaseMoney();
        return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
    }

    public WinningLotto setUpWinningLotto() {
        return new WinningLotto(setUpWinningNumbers(), setUpBonusNumber());
    }

    private Lotto setUpWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        return new Lotto(Converter.convertWinningNumber(winningNumbers));
    }

    private int setUpBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        return Converter.convertToNumeric(bonusNumber);
    }
}