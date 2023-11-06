package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoWinningProcess {
    public PurchaseMoney setUpPurchaseMoney() {
        String purchaseMoney = InputView.inputPurchaseMoney();
        return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
    }

    public List<Lotto> buyLotto() {
        PurchaseMoney purchaseMoney = setUpPurchaseMoney();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseMoney.getLottoTicketQuantity(); i++) {
            Lotto lotto = new Lotto(NumberGenerator.generate());
            OutputView.printLottoNumbers(lotto.getNumbers());
            lottos.add(lotto);
        }

        return lottos;
    }
}
