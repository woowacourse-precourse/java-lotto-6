package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoWinningProcess {
    public LottoResult run(List<Lotto> lottos, WinningLotto winningLotto) {
        //WinningLotto winningLotto = setUpWinningLotto();
        //WinningLotto winningLotto = setUpWinningLotto(winningNumbers);
        List<Integer> counted = new ArrayList<>();
        List<Boolean> checked = new ArrayList<>();

        for (Lotto lotto : lottos) {
            counted.add(winningLotto.getLotto().countOverlappingNumbers(lotto));
            checked.add(lotto.isContainBonusNumber(winningLotto.getBonusNumber()));
        }

        return new LottoResult(counted, checked);
    }

    public List<Lotto> buyLotto(PurchaseMoney purchaseMoney) {
        int lottoQuantity = purchaseMoney.getLottoQuantity();
        List<Lotto> lottos = new ArrayList<>();

        OutputView.printLottoQuantity(lottoQuantity);

        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = new Lotto(NumberGenerator.generate());
            lottos.add(lotto);

            OutputView.printLottoNumbers(lotto.getNumbers());
        }

        return lottos;
    }

    public PurchaseMoney setUpPurchaseMoney() {
        String purchaseMoney = InputView.inputPurchaseMoney();
        return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
    }

    public WinningLotto setUpWinningLotto(Lotto winningNumbers) {
        //return new WinningLotto(setUpWinningNumbers(), setUpBonusNumber());
        return new WinningLotto(winningNumbers,setUpBonusNumber());
    }

    public Lotto setUpWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        return new Lotto(Converter.convertWinningNumber(winningNumbers));
    }

    public int setUpBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        return Converter.convertToNumeric(bonusNumber);
    }
}