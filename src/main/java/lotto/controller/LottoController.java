package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.MyLottoNumbers;
import lotto.model.PurchasePrice;
import lotto.model.UniqueRandomNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final int ONE_LOTTO_PRICE = 1000;
    private PurchasePrice purchasePrice;
    private Lottos lottos;
    private MyLottoNumbers myLottoNumbers;

    public void start() {
        setPurchasePrice();
        makeSeveralLottos();
        makeMyLottoNumbers();
    }

    private void setPurchasePrice() {
        purchasePrice = new PurchasePrice(InputView.inputPrice());
    }

    private Lotto makeLotto() {
        return new Lotto(new UniqueRandomNumbers().getNumbers());
    }

    private void makeSeveralLottos() {
        lottos = new Lottos();
        for (int nums = 0; nums < purchasePrice.countPurchasedLottos(); nums++) {
            lottos.add(makeLotto());
        }
        OutputView.printLottos(lottos);
    }

    private void makeMyLottoNumbers() {
        myLottoNumbers = new MyLottoNumbers(InputView.inputMyLottoNumbers());
        myLottoNumbers.setBonusNumber(InputView.inputBonusNumber());
        System.out.println(myLottoNumbers.getMyNumbers());
        System.out.println(myLottoNumbers.getBonusNumber());
    }

}
